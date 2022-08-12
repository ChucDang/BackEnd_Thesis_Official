package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thud.luanvanofficial.entity.Category;

import java.util.Optional;

public interface CatergoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCode(String code);
}
