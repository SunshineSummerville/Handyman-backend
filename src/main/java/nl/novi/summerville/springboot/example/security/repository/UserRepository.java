package nl.novi.summerville.springboot.example.security.repository;

import nl.novi.summerville.springboot.example.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * De JpaRepositories die jullie al kennen. Hier wordt gebruik gemaakt van Query Creation. Op basis van de methode naam
 * weten Spring en JPA welke query op de database uitgevoerd moet worden.
 * Hier kan meer informatie over gevonden worden:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    List<User> findByPostalcode(String postalcode);

    Optional<User> findById(long id);
//    List<User> findUsersByCategoryId(long categoryId);


//    List<User> findUsersByCategoryHandymenCategoryId(long categoryId);
    //findBooksByBookPublishersPublisherId(Long publisherId)
}
