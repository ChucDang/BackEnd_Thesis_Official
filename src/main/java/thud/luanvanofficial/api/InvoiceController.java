package thud.luanvanofficial.api;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.service.InvoiceService;

@RestController
@RequestMapping(path = "/invoice")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class InvoiceController {
    private InvoiceService invoiceService;
    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    @PostMapping("saveInvoice")
    public ResponseEntity<?> saveInvoice( @AuthenticationPrincipal User user){
        return invoiceService.saveInvoice(user);
    }
}
