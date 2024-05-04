package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public List<Car> listCar() {
      return userDao.listCars();
   }
   @Transactional(readOnly = false)
   @Override
   public void clearTable() {
      userDao.clearTable();
   }

   @Transactional(readOnly = false)
   @Override
   public User searchUserByKar(String model, int series){
      return userDao.searchUserByKar(model, series);
   }
}
