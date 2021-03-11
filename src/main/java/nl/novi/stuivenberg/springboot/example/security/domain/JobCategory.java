//package nl.novi.stuivenberg.springboot.example.security.domain;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import java.util.List;
//
//@Entity
//public class JobCategory {
//
//    @Id
//    private String categoryName;// = Primary Key
//    @Column(nullable = false)
//    private String price; // start tarief - optioneel
//    @Column(nullable = false)
//    private String jobDescription;
//
//    @ManyToMany(mappedBy = "possibleCategories")
//    private List<User> handymen;
//
//
//
//    public JobCategory(){ //lege constuctor
//
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//
//    public String getJobDescription() {
//        return jobDescription;
//    }
//
//    public void setJobDescription(String jobDescription) {
//        this.jobDescription = jobDescription;
//    }
//
//    public List<User> getHandymen() {
//        return handymen;
//    }
//
//    public void setHandymen(List<User> handymen) {
//        this.handymen = handymen;
//    }
//}
