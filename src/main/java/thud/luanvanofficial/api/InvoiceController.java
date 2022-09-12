package thud.luanvanofficial.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.repository.InvoiceRepository;

@RestController
@RequestMapping(path = "/invoices")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080" })
public class InvoiceController {
    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
    @GetMapping
    public ResponseEntity<?> getAllInvoicesByUser(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(invoiceRepository.findByUser(user));
    }
}
