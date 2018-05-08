package pl.b2bnetwork.repository;

import org.springframework.data.repository.CrudRepository;
import pl.b2bnetwork.domain.Engine;

import java.util.List;

public interface EngineRepository extends CrudRepository<Engine, Long> {
    List<Engine> findAll();
}
