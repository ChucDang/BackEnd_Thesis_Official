package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thud.luanvanofficial.entity.Cart;
import thud.luanvanofficial.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
