package nl.novi.sunshine.backend.eindopdracht.service;

import nl.novi.sunshine.backend.eindopdracht.domain.ERole;
import nl.novi.sunshine.backend.eindopdracht.domain.Reservation;
import nl.novi.sunshine.backend.eindopdracht.domain.Role;
import nl.novi.sunshine.backend.eindopdracht.domain.User;
import nl.novi.sunshine.backend.eindopdracht.exception.UserNotFoundException;
import nl.novi.sunshine.backend.eindopdracht.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

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

    public User getUserById (Long id) {
        Optional<User> user = userRepository.findById(id);
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




//





}
