package pl.b2bnetwork.repository;

import org.springframework.data.repository.CrudRepository;
import pl.b2bnetwork.domain.Part;

import java.util.List;

public interface PartRepository extends CrudRepository<Part, Long> {
    List<Part> findAll();
}
