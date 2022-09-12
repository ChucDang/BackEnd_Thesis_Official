package thud.luanvanofficial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import thud.luanvanofficial.entity.Storage;

public interface StorageRepository extends JpaRepository<Storage, Integer> {
    @Query("Select a from Storage a where a.type = :type and a.code = :code and a.supportOptane = :supportOptane and a.storage = :storage ")
    Optional<Storage> findByType_Code_Optane_Storage(String type, String code, Boolean supportOptane, String storage);

}
