package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import thud.luanvanofficial.entity.Invoice;
import thud.luanvanofficial.entity.User;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Override
    Optional<Invoice> findById(Long idCart);
    @Query("select a from Invoice a where (a.cart.user = :user and a.isPaid = false )")
    Optional<Invoice> getByUserAndNotPaid(User user);

}
