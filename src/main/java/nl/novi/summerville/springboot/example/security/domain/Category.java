package nl.novi.summerville.springboot.example.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(columnDefinition = "serial") //serial elke entry ophogen met 1 opvolgende
    private long id;
    @Column
    private String name;// = Primary Key
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

    public String getName() {
        return name;
    }

    public void setName(String categoryName) {
        this.name = categoryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
