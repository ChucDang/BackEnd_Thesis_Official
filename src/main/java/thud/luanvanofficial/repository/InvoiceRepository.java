package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thud.luanvanofficial.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
