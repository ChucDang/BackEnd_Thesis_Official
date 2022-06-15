package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.Catergory;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select a from Product a where (a.catergory = :catergory)")
    List<Product> findAllByCatergoryCode(Optional<Catergory> catergory);
}
