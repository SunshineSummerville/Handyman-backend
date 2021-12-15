package nl.novi.summerville.springboot.example.security.service;

import nl.novi.summerville.springboot.example.security.domain.Category;
import nl.novi.summerville.springboot.example.security.repository.CategoryRepository;
import nl.novi.summerville.springboot.example.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public UserRepository userRepository;


    public List<Category> getAllCategories() {
        List<Category> allCategories = categoryRepository.findAll();
        return allCategories;

    }


}
