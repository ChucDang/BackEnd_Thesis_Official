package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thud.luanvanofficial.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
