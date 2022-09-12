package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import thud.luanvanofficial.entity.Stock;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query("select a from Stock a")
    List<Stock> getAllProducts();
    @Query("select a from Stock a where a.product.id = :productId and a.price = :price and a.stores.id =:idStore")
    Optional<Stock>  getStockByProductIdAndPriceAndStores(Long productId, Long price, Long idStore);

}
