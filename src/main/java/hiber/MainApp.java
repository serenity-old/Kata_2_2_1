/*package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      User User1 = new User("User1","Lastname1","user1@mail.ru");



      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));


      Car car1 = new Car("VAZ",2101);
      Car car2 = new Car("Lada",2110);
      Car car3 = new Car("Niva",2121);
      Car car4 = new Car("UAZ",452);




     // System.out.println(User1.getUserByCar(model,));







      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      System.out.println(userService.getUserByCar("VAZ",2101));

      context.close();
   }
}*/

package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User roma = new User("Рома", "Федоров", "roma@mail.ru");
        User petya = new User("Петя", "Петров", "petya@mail.ru");
        User olya = new User("Оля", "Куриленко", "olya@mail.ru");
        User natasha = new User("Наташа", "Королева", "natasha@mail.ru");

        Car volga = new Car("Volga", 24);
        Car lada = new Car("Lada", 2110);
        Car niva = new Car("Niva", 2121);
        Car uaz = new Car("UAZ", 452);

        userService.add(roma.setCar(volga).setUser(roma));
        userService.add(petya.setCar(lada).setUser(petya));
        userService.add(olya.setCar(niva).setUser(olya));
        userService.add(natasha.setCar(uaz).setUser(natasha));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user + " " + user.getCar());
            System.out.println("1. _________________________________________");
        }

        System.out.println(userService.getUserByCar("Volga", 24));
        System.out.println("2. _____________________________________________");

        context.close();
    }
}