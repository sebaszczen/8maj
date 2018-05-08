package pl.b2bnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.b2bnetwork.domain.Car;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findAll();
}
