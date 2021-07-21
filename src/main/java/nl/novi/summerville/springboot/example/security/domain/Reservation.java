package nl.novi.summerville.springboot.example.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator ="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial")
    private long reservationNr; // reservationNr = primary key
    @Column(nullable = false)
    private String reservationDate;

    @ManyToOne
    @JsonIgnore
    private User handyman;

    @ManyToOne
    @JsonIgnore
    // JsonIgnore is om te voorkomen dat dat er oneindige loop van users worden aangemaakt.
    // De bidirectionele relatie zorgt ervoor dat we de "user" kunnen opvragen
    // en de "reservation" automatisch meekomt. De reservering  heeft ook users en die komt ook automatisch mee.
    private User customer;


    @ManyToOne
    private Category category;

    public Reservation() { // lege constructor

    }

    public Reservation(String reservationDate) { // constructor gelinkt met controller
        this.reservationDate = reservationDate;
    }

    public Reservation(String reservationDate, User handyman, User customer) {
        this.reservationDate = reservationDate;
        this.handyman = handyman;
        this.customer = customer;
    }

    public long getReservationNr() {
        return reservationNr;
    }

    public void setReservationNr(long reservationNr) {
        this.reservationNr = reservationNr;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public User getHandyman() {
        return handyman;
    }

    public void setHandyman(User handyman) {
        this.handyman = handyman;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

        public void setCategory(Category category) {
        this.category = category;
        }

        public Category getCategory() {
        return category;
        }

}
