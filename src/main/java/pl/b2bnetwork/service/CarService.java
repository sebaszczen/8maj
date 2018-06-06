package pl.b2bnetwork.service;

import pl.b2bnetwork.domain.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car findOne(Long id);
    void save(Car car,Long id);
    void delete(Long id);
}
