package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import thud.luanvanofficial.entity.Order;
import thud.luanvanofficial.entity.User;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select a from Order a where (a.user = :user) ")
    List<Order> findAllByUser(User user);
}
