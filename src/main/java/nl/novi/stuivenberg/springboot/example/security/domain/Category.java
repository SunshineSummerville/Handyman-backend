package nl.novi.stuivenberg.springboot.example.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private String categoryName;// = Primary Key
    @Column(nullable = false)
    private String price; // start tarief - optioneel
    @Column(nullable = false)
    private String jobDescription;

    @JsonIgnore
    @ManyToMany
//    (mappedBy = "possible_categories",
//    fetch = FetchType.LAZY)
    private List<User> handymen;



    public Category(){ //lege constuctor

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public List<User> getHandymen() {
        return handymen;
    }

    public void setHandymen(List<User> handymen) {
        this.handymen = handymen;
    }
}
