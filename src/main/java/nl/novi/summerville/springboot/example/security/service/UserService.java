package nl.novi.summerville.springboot.example.security.service;

import nl.novi.summerville.springboot.example.security.domain.*;
import nl.novi.summerville.springboot.example.security.repository.CategoryRepository;
import nl.novi.summerville.springboot.example.security.repository.ReservationRepository;
import nl.novi.summerville.springboot.example.security.repository.UserRepository;
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

    @Autowired
    public ReservationRepository reservationRepository;

    @Autowired
    public CategoryRepository categoryRepository;


    public User getUserByUsername (String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public boolean addCategoryToUser (long userId, long categoryId ) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Category> categoryToAdd = categoryRepository.findById(categoryId);
        if (user.isPresent()&& categoryToAdd.isPresent()) {
            User userFromDb = user.get();
            Set<Category> categories = userFromDb.getCategories();
            categories.add(categoryToAdd.get());

            userFromDb.setCategories(categories);
            userRepository.save(userFromDb);
            return true;
        }



        return false;
    }

    public boolean removeCategoryFromUser (long userId, long categoryId ) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Category> categoryToAdd = categoryRepository.findById(categoryId);
        if (user.isPresent()&& categoryToAdd.isPresent()) {
            User userFromDb = user.get();
            Set<Category> categories = userFromDb.getCategories();
            categories.remove(categoryToAdd.get());

            userFromDb.setCategories(categories);
            userRepository.save(userFromDb);
            return true;
        }



        return false;
    }

    public List<Reservation> getReservationsByHandymanId (long id) {
        List<Reservation> myReservations = reservationRepository.findByHandymanId(id);

        return myReservations;
    }

    public List<Reservation> getReservationsByCustomerId (long id) {
        List<Reservation> myReservations = reservationRepository.findByCustomerId(id);

        return myReservations;
    }



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
















}
