package nl.novi.summerville.springboot.example.security.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {

    @NotBlank //can be applied only to text values and validates that the property is not null or whitespace.
    @Size(min = 3, max = 20)
    private String username;
    @Size(min = 2, message = "firstname should contain at least 2 letters.")
    private String firstname;
    @Size(min = 2, message = "lastname should contain at least 2 letters.")
    private String lastname;

    @NotBlank
    @Size(max = 50)
    @Email(message = "Please, write a correct email. ") //Validates that the given email is a valid email address.
    private String email;
    @Size(min = 3, max = 10)
    private String phonenumber;
    private String streetname;
    private String housenumber;
    @NotBlank
    @Size(max = 6, message = "Postalcode should be 4 numbers and 2 letters")
    private String postalcode;
    private String provincie;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getProvincie() {
        return provincie;
    }

    public void setProvincie(String provincie) {
        this.provincie = provincie;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
