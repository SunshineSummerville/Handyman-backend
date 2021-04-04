package nl.novi.stuivenberg.springboot.example.security.service.security;

import nl.novi.stuivenberg.springboot.example.security.domain.ERole;
import nl.novi.stuivenberg.springboot.example.security.domain.Role;
import nl.novi.stuivenberg.springboot.example.security.domain.User;
import nl.novi.stuivenberg.springboot.example.security.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    //@Autowired
    public UserRepository UserRepository;

    public List<User> findHandymanByPostalcode(String postalcode) {
        List<User> handyMen = new ArrayList<>();

        List<User> foundUsers = UserRepository.findByPostalCode(postalcode);

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
        List<User> allUsers = UserRepository.findAll();
        return allUsers;
    }

    public Optional<User> getUserById(Long userId) {
        return UserRepository.findById(userId);
    }


    public User addUser(User newUser) {
        return UserRepository.save(newUser);
    }


    public String deleteUserById (Long userId) {
        Optional<User> user = UserRepository.findById(userId);
        if(user.isPresent()) {
            UserRepository.deleteById(userId);
            return "User met id " + user.get().getUserId() + " is verwijderd";
        }
        throw new UserNotFoundException("Gebruiker bestaat niet. Probeer opnieuw");

        //return appUserRepository.deleteById(userId);
    }

    public User updateUserById(Long id, User updatedUser) {
        Optional<User> userFromDb = UserRepository.findById(id);

        if(userFromDb.isPresent()) { // check of gebruiker aanwezig is adhv naam en email
            if (checkIsValidName(updatedUser.getFirstName())) {
               User user = new User();
                User.setFirstName(updatedUser.getFirstName());
                User.setLastName(updatedUser.getLastName());
                User.setEmail(updatedUser.getEmail());
                return UserRepository.save(User);
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
