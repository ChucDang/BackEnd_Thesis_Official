package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thud.luanvanofficial.entity.Cart;
import thud.luanvanofficial.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
