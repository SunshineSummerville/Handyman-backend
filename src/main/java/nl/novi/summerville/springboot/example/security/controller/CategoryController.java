package nl.novi.summerville.springboot.example.security.controller;

import nl.novi.summerville.springboot.example.security.domain.Category;
import nl.novi.summerville.springboot.example.security.repository.CategoryRepository;
import nl.novi.summerville.springboot.example.security.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    public CategoryRepository categoryRepository;


    @GetMapping (value = "/categories")
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }


}
