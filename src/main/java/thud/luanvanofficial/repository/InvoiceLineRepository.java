package thud.luanvanofficial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thud.luanvanofficial.entity.InvoiceLine;

public interface InvoiceLineRepository extends JpaRepository<InvoiceLine, Long> {
}
