package nl.novi.summerville.springboot.example.security.controller;

import nl.novi.summerville.springboot.example.security.domain.Reservation;
import nl.novi.summerville.springboot.example.security.domain.User;
import nl.novi.summerville.springboot.example.security.payload.request.AddCategoryRequest;
import nl.novi.summerville.springboot.example.security.repository.UserRepository;
import nl.novi.summerville.springboot.example.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    public UserRepository userRepository;


    @GetMapping (value = "/user/{username}")
    public User getUserByUsername(@PathVariable String username) {

        return userService.getUserByUsername(username);
    }

    @PostMapping(value = "/user/{id}/categories")
    public ResponseEntity<Long> addCategoryToHandyman (@PathVariable long id, @RequestBody AddCategoryRequest addCategoryRequest){
        userService.addCategoryToUser(id,addCategoryRequest.getCategoryId());
        return ResponseEntity.status(HttpStatus.CREATED).body(addCategoryRequest.getCategoryId());
    }

    @DeleteMapping(value = "/user/{id}/categories")
    public ResponseEntity<Long> removeCategoryToHandyman (@PathVariable long id, @RequestBody AddCategoryRequest addCategoryRequest){
        userService.removeCategoryFromUser(id,addCategoryRequest.getCategoryId());
        return ResponseEntity.status(HttpStatus.OK).body(addCategoryRequest.getCategoryId());
    }

    @GetMapping (value = "/user/{id}/reservations")
    public List<Reservation> getReservationsByUserId(@PathVariable long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_HANDYMAN"))) {
            System.out.println("HANDYMAN");
            return userService.getReservationsByHandymanId(id);

        }else{
            return userService.getReservationsByCustomerId(id);

        }

    }


}
