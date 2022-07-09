package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import thud.luanvanofficial.entity.Cart;
import thud.luanvanofficial.entity.User;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("select a from Cart a where (a.user = :user)")
   Optional<Cart>  getByUser(User user);
}
