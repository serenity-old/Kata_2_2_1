package hiber.dao;

import hiber.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   @SuppressWarnings("unchecked")
   @Transactional
    User getUserByCar(String model, int series);
}

