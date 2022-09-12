package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import thud.luanvanofficial.entity.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, String> {
    @Query("select a from Brand a where (a.category.code = :category)")
    List<Brand> findAllBrandsByCategoryCode(String category);

    @Query("select a.name from Brand a where (a.category.code = :category)")
    List<String> getStringBrandsByCategoryCode(String category);
    @Query("select a from Brand a where (a.name = :name)")
    Optional<Brand> findByName(String name);
}
