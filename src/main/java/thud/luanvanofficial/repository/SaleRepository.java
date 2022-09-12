package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thud.luanvanofficial.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, String> {
}
