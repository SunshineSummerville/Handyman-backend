package nl.novi.summerville.springboot.example.security.service;

import nl.novi.summerville.springboot.example.security.domain.ERole;
import nl.novi.summerville.springboot.example.security.domain.Reservation;
import nl.novi.summerville.springboot.example.security.domain.Role;
import nl.novi.summerville.springboot.example.security.domain.User;
import nl.novi.summerville.springboot.example.security.exception.UserNotFoundException;
import nl.novi.summerville.springboot.example.security.repository.ReservationRepository;
import nl.novi.summerville.springboot.example.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

//@CrossOrigin
@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public ReservationRepository reservationRepository;

    public List<User> findHandymanByPostalcode(String postalcode) {
        List<User> handyMen = new ArrayList<>();

        List<User> foundUsers = userRepository.findByPostalcode(postalcode);

        for(User user : foundUsers) {
            Set<Role> foundRoles = user.getRoles();
            for(Role role : foundRoles) {
                if(role.getName().equals(ERole.ROLE_HANDYMAN)) {
                    handyMen.add(user);
                }
            }
        }

        return handyMen;
    }

    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    public User getUserByUsername (String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }


    public User saveUser(User newUser) {
        return userRepository.save(newUser);
    }


    public String deleteUserById (Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            userRepository.deleteById(userId);
            return "User met id " + user.get().getId() + " is verwijderd";
        }
        throw new UserNotFoundException("Gebruiker bestaat niet. Probeer opnieuw");

        //return appUserRepository.deleteById(userId);
    }

    public User updateUserById(Long id, User updatedUser) {
        Optional<User> userFromDb = userRepository.findById(id);

        if(userFromDb.isPresent()) { // check of gebruiker aanwezig is adhv naam en email
            if (checkIsValidName(updatedUser.getFirstname())) {
               User user = new User();
                user.setFirstname(updatedUser.getFirstname());
                user.setLastname(updatedUser.getLastname());
                user.setEmail(updatedUser.getEmail());
                return userRepository.save(user);
            }
        }
        throw new UserNotFoundException(id);
    }

    private boolean checkIsValidName(String name) { // validatie, bovenstaande code op het moment dat we een gebruiker aanpassen.
        return !name.contains("fuck") && !name.equalsIgnoreCase("");
    }

    public User addReservationToUser(long id, Reservation newReservation) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) { // check: gebruiker is aanwezig
            User userFromDb = user.get();
            List<Reservation> currentReservations = userFromDb.getReservations();
            newReservation.setCustomer(userFromDb); // ??
//
//            if(newReservation.get () == null || newReservation.getappUser ().getId() != id) {
//
//            }
            currentReservations.add(newReservation);
            userFromDb.setReservations(currentReservations);
            return userRepository.save(userFromDb);
        }

        return null;
    }


    public List<Reservation> getReservationsByUserId (long id) {
        List<Reservation> myReservations = reservationRepository.findByCustomerId(id);

        return myReservations;
    }










}
