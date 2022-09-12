package thud.luanvanofficial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import thud.luanvanofficial.entity.RAM;

public interface RamRepository extends JpaRepository<RAM, Integer> {
    @Query("Select a from RAM a where a.type = :type and a.storage = :storage and a.speed =:speed and a.supportMaxSpeed = :supportMaxSpeed")
    Optional<RAM> findByType_Storage_Speed_MaxSpeed(String type, int storage, float speed, float supportMaxSpeed);
}
