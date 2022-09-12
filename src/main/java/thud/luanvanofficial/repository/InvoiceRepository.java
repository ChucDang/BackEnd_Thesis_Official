package thud.luanvanofficial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import thud.luanvanofficial.entity.Invoice;
import thud.luanvanofficial.entity.User;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query("Select a from Invoice a where a.user = :user")
    List<Invoice> findByUser(User user);
}
