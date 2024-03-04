package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.addUserWithCar("Name1", "LastName1", "email1@example.com", "Mazda", 2010);
      userService.addUserWithCar("Name2", "LastName2", "email2@example.com", "Toyota", 2020);
      userService.addUserWithCar("Name3", "LastName3", "email3@example.com", "Nissan", 2001);
      userService.addUserWithCar("Name4", "LastName4", "email4@example.com", "Zhiguli", 1996);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         if(user.getCar() != null) {
            System.out.println("Car Model = " + user.getCar().getModel());
            System.out.println("Car Series = " + user.getCar().getSeries());
         }
         System.out.println();
      }

      User foundUser = userService.findUserByCar("Toyota", 2020);
      if (foundUser != null) {
         System.out.println("Найден пользователь с автомобилем " + foundUser.getCar().getModel() + ": " + foundUser.getFirstName() + " " + foundUser.getLastName());
      } else {
         System.out.println("Пользователь с такой машиной не найден.");
      }

      context.close();
   }
}
