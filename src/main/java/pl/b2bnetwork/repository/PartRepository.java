package pl.b2bnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.b2bnetwork.domain.Part;

import java.util.List;

public interface PartRepository extends JpaRepository<Part, Long> {
    List<Part> findAll();

}
