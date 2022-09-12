package thud.luanvanofficial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import thud.luanvanofficial.entity.Gift;
import thud.luanvanofficial.entity.Product;

public interface GiftRepository extends JpaRepository<Gift, String> {
    @Query("select a from Product a where (a.gift = :gift)")
    List<Product> findProductsByGift(Gift gift);
}
