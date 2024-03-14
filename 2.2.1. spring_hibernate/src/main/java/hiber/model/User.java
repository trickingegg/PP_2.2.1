package hiber.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "car_id")
   private Car car;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
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

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, firstName, lastName, email, car);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (!(obj instanceof User)) {
         return false;
      }
      User other = (User) obj;
      return Objects.equals(id, other.id)&&
              Objects.equals(firstName, other.firstName) &&
              Objects.equals(lastName, other.lastName) &&
              Objects.equals(email, other.email) &&
              Objects.equals(car, other.car);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Id = : ").append(id).append('\n');
      sb.append("FirstName : ").append(firstName).append('\n');
      sb.append("LastName : ").append(lastName).append('\n');
      sb.append("Email : ").append(email).append('\n');
      sb.append("Car : ").append(car != null ? car.toString() : "null").append('\n');
      return sb.toString();
   }
}
