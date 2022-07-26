package thud.luanvanofficial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import thud.luanvanofficial.entity.Cart;
import thud.luanvanofficial.entity.Invoice;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.repository.CartRepository;
import thud.luanvanofficial.repository.InvoiceRepository;

import java.util.Optional;

@Service
public class InvoiceService {
    private InvoiceRepository invoiceRepository;
    private CartRepository cartRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository, CartRepository cartRepository) {
        this.invoiceRepository = invoiceRepository;
        this.cartRepository = cartRepository;
    }


    public ResponseEntity<?> saveInvoice(User user) {
        Optional<Cart> cart = cartRepository.getByUser(user);
        Optional<Invoice> existInvoiceNotPaid = invoiceRepository.getByUserAndNotPaid(user);
        if (existInvoiceNotPaid.isEmpty()) {
            Invoice invoice = new Invoice(cart.get(), false);
            invoiceRepository.save(invoice);
            return ResponseEntity.ok("Đã tạo hóa đơn mới");

        } else {
            existInvoiceNotPaid.get().getCart().getCartLines().addAll(cart.get().getCartLines());
            invoiceRepository.save(existInvoiceNotPaid.get());
            return ResponseEntity.ok("Đã thêm sản phẩm vào hóa đơn đang có");
        }
    }
}
