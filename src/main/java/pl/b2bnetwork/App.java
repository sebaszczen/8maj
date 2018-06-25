package pl.b2bnetwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.b2bnetwork.domain.Car;
import pl.b2bnetwork.repository.CarRepository;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


@SpringBootApplication
public class App {

    private static final String URL ="jdbc:mysql://localhost:3306/8thmay";
    private static final String PASSWORD ="tajne";
    private static final String ROOT ="root" ;

    @Autowired
    CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);



        try {
            Connection connection= DriverManager.getConnection(URL, ROOT, PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM CAR");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
