package ink.organics.demo.jpa.model.repository;

import ink.organics.demo.jpa.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
}
