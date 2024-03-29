package nl.novi.summerville.springboot.example.security.repository;

import nl.novi.summerville.springboot.example.security.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findAll();
    Optional <Category> findById(long id);

}
