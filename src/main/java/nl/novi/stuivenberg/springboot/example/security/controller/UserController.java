package nl.novi.stuivenberg.springboot.example.security.controller;

import nl.novi.stuivenberg.springboot.example.security.domain.Reservation;
import nl.novi.stuivenberg.springboot.example.security.domain.User;
import nl.novi.stuivenberg.springboot.example.security.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    //@Autowired
    UserService userService;

    //@Autowired
    public UserRepository userRepository;

    @GetMapping("/handyman/{postalcode}")
    public List<User> findHandymenByPostalCode(@PathVariable String postalcode) {
        return userService.findHandymanByPostalcode(postalcode);
    }

    @GetMapping (value = "/user")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping (value = "/api/user/{id}")
    public User getUserById (@PathVariable Long id) {
        Optional<User> User = User.findById(id);
        if(User.isPresent()) {
            return User.get();
        }
        return null;
    }

    @PostMapping(value = "api/user")
    public User saveUser (@RequestBody User newUser) {
        return UserRepository.save(newUser);
    }

    @DeleteMapping(value = "/api/user/{id}")
    public String deleteUser(@PathVariable long id) {
        return userService.deleteUserById (id);
    }

    @PutMapping(value = "/api/user/{id}")
    public User updateUserById(@PathVariable long id, @RequestBody User updatedUser) {
        return userService.updateUserById(id, updatedUser);
    }


    //    @DeleteMapping (value = "/api/appuser/{id}")
//    public void deleteAppUser (@PathVariable Long id){
//        Optional<ApplicationUser> appUser = appUserRepository.findById(id);
//        if(appUser.isPresent()) {
//            appUserRepository.deleteById(id);
//            return "User met id " + appUser.get().getUserId () + " is verwijderd";
//        }
//        throw new UserNotFoundException("Hallo, ik besta niet");
//
//    }
//
//    @PutMapping(value = "/api/user/{id}")
//    public ApplicationUser updateUserById(@PathVariable long id, @RequestBody ApplicationUser updatedUser) {
//        return applicationUserRepository.findById(id).map(
//                user -> {
//                    user.setName(updatedUser.getName());
//                    user.setEmail(updatedUser.getEmail());
//                    return applicationUserRepository.save(user);
//                })
//                // Kan de user niet vinden in database
//                .orElseGet(() -> {
//                    updatedUser.setId(id);
//                    return applicationUserRepository.save(updatedUser);
//                });
//    }
//
    @PutMapping("/api/user/{id}/reservation") // add made reservation: reservation is made by customer which will be assigned to a appuser in the database
    public User addReservationToUser(@PathVariable long id, @RequestBody Reservation newReservation) {
        Optional<User> user = UserRepository.findById(id);

        if(user.isPresent()) { // check: gebruiker is aanwezig
            User userFromDb = user.get();
            List<Reservation> currentReservations = userFromDb.getReservations();

            newReservation.setCustomer (userFromDb); // ??
//
//            if(newReservation.get () == null || newReservation.getappUser ().getId() != id) {
//
//            }

            currentReservations.add(newReservation);
            userFromDb.setReservations(currentReservations);

            return UserRepository.save(userFromDb);
        }

        return null;

    }

//    @PostMapping("/api/user/fill")
//    public User addTestUsers() {
//        return userService.addTestUserWithReservations();
//    }
//




}
