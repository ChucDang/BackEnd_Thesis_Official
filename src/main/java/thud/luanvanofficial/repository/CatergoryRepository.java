package thud.luanvanofficial.repository.catalogRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import thud.luanvanofficial.entity.Catergory;

import java.util.Optional;

public interface CatergoryRepository extends JpaRepository<Catergory, Long> {
    Optional<Catergory> findByCode(String code);
}
