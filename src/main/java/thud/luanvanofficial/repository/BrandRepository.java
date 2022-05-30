package thud.luanvanofficial.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thud.luanvanofficial.entity.Brand;
@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
}
