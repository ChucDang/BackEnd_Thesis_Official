package thud.luanvanofficial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import thud.luanvanofficial.entity.CPU;

public interface CPURepository extends JpaRepository<CPU, Integer> {
    @Query("Select a from CPU a where a.brand = :brand and a.version = :version")
    Optional<CPU> findByBrandAndVersion(String brand, String version);
}
