package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thud.luanvanofficial.entity.CartLine;

public interface OrderRepository extends JpaRepository<CartLine, Long> {

}
