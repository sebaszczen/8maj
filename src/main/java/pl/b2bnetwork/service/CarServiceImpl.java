package pl.b2bnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.b2bnetwork.domain.Car;
import pl.b2bnetwork.domain.Engine;
import pl.b2bnetwork.domain.Part;
import pl.b2bnetwork.repository.CarRepository;
import pl.b2bnetwork.repository.EngineRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private EngineRepository engineRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findOne(Long id) {
        return carRepository.findOne(id);
    }

    @Override
    public void save(Car car, Long id) {

        Engine engine = engineRepository.findOne(id);

        car.setEngine(engine);
            engine.setCar(car);

        carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        carRepository.delete(id);
    }
}
