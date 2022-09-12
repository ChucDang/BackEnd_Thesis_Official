package thud.luanvanofficial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import thud.luanvanofficial.dto.CustomerOrdersResponse;
import thud.luanvanofficial.dto.MessageResponse;
import thud.luanvanofficial.dto.OrderDTO;
import thud.luanvanofficial.entity.*;
import thud.luanvanofficial.enums.OrderStatus_Enum;
import thud.luanvanofficial.repository.*;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private OrderLineRepository orderLineRepository;
    private CartRepository cartRepository;
    private CartLineRepository cartLineRepository;
    private InvoiceLineRepository invoiceLineRepository;
    private InvoiceRepository invoiceRepository;

    @Autowired

    public OrderService(OrderRepository orderRepository, OrderLineRepository orderLineRepository,
            CartRepository cartRepository, CartLineRepository cartLineRepository,
            InvoiceLineRepository invoiceLineRepository, InvoiceRepository invoiceRepository) {
        this.orderRepository = orderRepository;
        this.orderLineRepository = orderLineRepository;
        this.cartRepository = cartRepository;
        this.cartLineRepository = cartLineRepository;
        this.invoiceLineRepository = invoiceLineRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public ResponseEntity<?> saveOrder(OrderDTO orderDTO, User user) {
        if (orderDTO.getOrderLines().size() > 0) {
            Order newOrder = new Order(orderDTO);
            // Lưu Order mới

            List<OrderLine> newList = orderLineRepository.saveAll(orderDTO.getOrderLines());
            // Xóa các CartLine cũ, vì các Cartline này đã chuyển thành OrderLine rồi.

            newOrder.setUser(user);
            newOrder.setOrderLines(newList);

            Order savedOrder = orderRepository.save(newOrder);

            Optional<Cart> existCart = cartRepository.getByUser(user);
            if (existCart.isPresent()) {
                List<CartLine> oldCartLines = existCart.get().getCartLines();
                if (oldCartLines.size() > 0) {
                    existCart.get().setCartLines(null);
                    cartLineRepository.deleteAll(oldCartLines);
                }
                cartRepository.delete(existCart.get());
            }
            return ResponseEntity.ok(savedOrder);
        }
        return ResponseEntity.ok(new Order());

    }

    public ResponseEntity<?> getOrders(User user) {

        return ResponseEntity.ok(orderRepository.findAllByUser(user));
    }

    public ResponseEntity<?> deleteOrder(Long idOrder) {
        Optional<Order> existOrder = orderRepository.findById(idOrder);
        if (existOrder.isPresent()) {
            List<OrderLine> orderLines = existOrder.get().getOrderLines();
            existOrder.get().setOrderLines(null);
            orderLineRepository.deleteAll(orderLines);
            orderRepository.delete(existOrder.get());
            return ResponseEntity.ok(new MessageResponse("Order đã được xóa thành công."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order không tồn tại!!!");
        }

    }

    public ResponseEntity<?> getAllCustomerOrders() {

        CustomerOrdersResponse _return = new CustomerOrdersResponse(orderRepository.findAll(),
                invoiceRepository.findAll());
        return ResponseEntity.ok(_return);
    }

    public ResponseEntity<?> editStatusOrder(Long id, String status) {
        Optional<Order> existOrder = orderRepository.findById(id);

        if (existOrder.isPresent()) {

            if (status.equalsIgnoreCase(OrderStatus_Enum.Finish.toString())) {
                // ListIterator<OrderLine> listIterator =
                // existOrder.get().getOrderLines().listIterator();
                // List<InvoiceLine> invoiceLines = new ArrayList<>();
                // while(listIterator.hasNext()){
                // OrderLine temp = listIterator.next();
                // InvoiceLine newInvoiceLine = new InvoiceLine();
                // newInvoiceLine.setProduct(temp.getProduct());
                // newInvoiceLine.setAmount(temp.getAmount());
                // newInvoiceLine.setSale(temp.getSale());
                // invoiceLines.add(newInvoiceLine);
                // }
                Invoice newInvoice = new Invoice(existOrder.get());
                invoiceLineRepository.saveAll(newInvoice.getInvoiceLines());

                invoiceRepository.save(newInvoice);

                // Xóa OrderLine và Order cũ
                List<OrderLine> oldOrderLines = existOrder.get().getOrderLines();
                existOrder.get().setOrderLines(null);
                orderLineRepository.deleteAll(oldOrderLines);
                orderRepository.delete(existOrder.get());

            } else {
                existOrder.get().setStatus(status);
                orderRepository.save(existOrder.get());

            }
            CustomerOrdersResponse _return = new CustomerOrdersResponse(orderRepository.findAll(),
                    invoiceRepository.findAll());
            return ResponseEntity.ok(_return);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Order không có trên hệ thống"));

    }
}
