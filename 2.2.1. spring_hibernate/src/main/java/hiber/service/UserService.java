package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    User findUserByCar(String model, int series);
    void addUserWithCar(String firstName, String lastName, String email, String model, int series);
}
