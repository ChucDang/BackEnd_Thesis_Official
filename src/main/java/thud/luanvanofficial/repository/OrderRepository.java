package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thud.luanvanofficial.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
