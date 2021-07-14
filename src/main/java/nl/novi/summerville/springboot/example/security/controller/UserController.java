package nl.novi.summerville.springboot.example.security.controller;

import nl.novi.summerville.springboot.example.security.domain.Reservation;
import nl.novi.summerville.springboot.example.security.domain.User;
import nl.novi.summerville.springboot.example.security.repository.UserRepository;
import nl.novi.summerville.springboot.example.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/handyman/{postalcode}")
    public List<User> findHandymenByPostalCode(@PathVariable String postalcode) {
        return userService.findHandymanByPostalcode(postalcode);
    }

    @GetMapping (value = "/user")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping (value = "/user/{id}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }


    @PostMapping(value = "/user")
    public User saveUser (@RequestBody User newUser) {
        return userService.saveUser(newUser);
    }

    @DeleteMapping(value = "/user/{id}")
    public String deleteUser(@PathVariable long id) {
        return userService.deleteUserById (id);
    }

    @PutMapping(value = "/user/{id}")
    public User updateUserById(@PathVariable long id, @RequestBody User updatedUser) {
        return userService.updateUserById(id, updatedUser);
    }

    @PutMapping("/user/{id}/reservation") // add made reservation: reservation is made by handyman which will be assigned to a appuser in the database
    public User addReservationToUser(@PathVariable long id, @RequestBody Reservation newReservation) {
        return userService.addReservationToUser(id, newReservation);
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



//    @PostMapping("/api/user/fill")
//    public User addTestUsers() {
//        return userService.addTestUserWithReservations();
//    }
//




}
