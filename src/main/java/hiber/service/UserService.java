package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    List<Car> listCar();
    void clearTable();
    User searchUserByKar(String model,int series);
}
