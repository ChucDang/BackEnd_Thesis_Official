package thud.luanvanofficial.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.Category;
import thud.luanvanofficial.entity.Sale;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select a from Product a where (a.brand.category = :category)")
    Page<Product> findAllByCategoryCode(Optional<Category> category, Pageable pageable);


    @Query("select a from Product a where (a.id = :id)")
    Product findProductById(Long id);
    @Query("select a from Product a where (a.sale = :sale)")
    List<Product> findProductsBySale(Sale sale);
    
  
}
