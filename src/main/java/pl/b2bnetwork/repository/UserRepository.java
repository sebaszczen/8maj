package pl.b2bnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pl.b2bnetwork.domain.User.User;

import java.util.Optional;

@Service
public interface UserRepository extends JpaRepository<User,Long>{
    Optional <User> findByName(String userName);
}
