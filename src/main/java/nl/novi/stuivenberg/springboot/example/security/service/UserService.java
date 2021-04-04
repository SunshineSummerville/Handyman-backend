package nl.novi.stuivenberg.springboot.example.security.service;

import nl.novi.stuivenberg.springboot.example.security.domain.ERole;
import nl.novi.stuivenberg.springboot.example.security.domain.Role;
import nl.novi.stuivenberg.springboot.example.security.domain.User;
import nl.novi.stuivenberg.springboot.example.security.exception.UserNotFoundException;
import nl.novi.stuivenberg.springboot.example.security.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    //@Autowired
    public UserRepository userRepository;

    public List<User> findHandymanByPostalcode(String postalcode) {
        List<User> handyMen = new ArrayList<>();

        List<User> foundUsers = userRepository.findByPostalCode(postalcode);

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

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }


    public User addUser(User newUser) {
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
                User.setFirstname(updatedUser.getFirstname());
                User.setLastname(updatedUser.getLastname());
                User.setEmail(updatedUser.getEmail());
                return userRepository.save(User);
            }
        }
        throw new UserNotFoundException(id);
    }

    private boolean checkIsValidName(String name) {
        return !name.contains("fuck") && !name.equalsIgnoreCase("");
    }

//    public ApplicationUser addTestUserWithReservations() {
//        ApplicationUser user = new ApplicationUser();
//        user.setFirstName("Sunshine");
//        user.setLastName("Summerville");
//        user.setEmail("sunshine.summerville@gmail.com");

//        Reservation Reservation = new Reservation();
//        barra.setName("Barra");
//        barra.setSpecies("vuilnisbak");
//        barra.setFemale(true);
//        barra.setFurColour("black");
//
//        Dog joop = new Dog();
//        joop.setName("Joop");
//        joop.setSpecies("Hyperactief");
//        joop.setFemale(false);
//        joop.setFurColour("mixed");
//
//        user.setDogs(Arrays.asList(barra, joop));
//        barra.setOwner(user);
//        joop.setOwner(user);
//
//        return appUserRepository.save(user);
//    }



//





}
