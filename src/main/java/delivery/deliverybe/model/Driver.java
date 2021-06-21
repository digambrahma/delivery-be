package delivery.deliverybe.model;

import delivery.deliverybe.custom_constraint.EmailConstraint;
import delivery.deliverybe.custom_constraint.PhoneConstraint;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Document(collection = "Driver")
public class Driver {

    @Id
    private String driverId;

    @NotNull(message = "Fist name of driver cannot be null!")
    @Size(min = 4, max = 255, message = "First name must have more then four characters, and have less then 256" +
            " characters")
    private String firstName;

    @NotNull(message = "Last name of driver cannot be null!")
    @Size(min = 4, max = 255, message = "Last name must have more then four characters, and have less then 256" +
            " characters")
    private String lastName;

    @NotNull(message = "Email of driver cannot be null!")
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "Please enter a valid" +
            " email")
    @EmailConstraint(message = "The email already in use, please try with another email!")
    private String email;

    @NotNull(message = "Please enter a phone number!")
    @Size(min = 10, max = 10, message = "Phone number must contain 10 digits!")
    @Pattern(regexp = "([0-9]+)")
    @PhoneConstraint(message = "Phone Number already taken please type another number!")
    private String phone;

    @NotNull(message = "Please enter your city!")
    private String city;

    private Boolean status;

    private List<String> coordinates;

    @DBRef
    private List<Delivery> deliveries;

    public Driver(
            String firstName, String lastName, String email, String phone, String city, Boolean status,
            List<String> coordinates, List<Delivery> deliveries
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.status = status;
        this.coordinates = coordinates;
        this.deliveries = deliveries;
    }

    public Driver() {
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<String> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<String> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", status=" + status +
                ", coordinates=" + coordinates +
                ", deliveries=" + deliveries +
                '}';
    }
}
















