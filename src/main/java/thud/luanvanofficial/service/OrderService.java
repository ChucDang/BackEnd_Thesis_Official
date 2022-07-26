package thud.luanvanofficial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import thud.luanvanofficial.dto.CartDTO;
import thud.luanvanofficial.dto.OrderDTO;
import thud.luanvanofficial.entity.Order;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.repository.CartRepository;
import thud.luanvanofficial.repository.OrderRepository;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private CartRepository cartRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    public ResponseEntity<?> saveOrder(OrderDTO orderDTO, User user) {
        Order order = new Order(orderDTO.getDeliveryName(),orderDTO.getDeliveryAddress(), orderDTO.getDeliveryPhone(),orderDTO.getDeliveryNote() ,orderDTO.getCartLines(), user);
        orderRepository.save(order);
        cartRepository.delete(cartRepository.getById(orderDTO.getIdCart()));
        return ResponseEntity.ok(order);
    }

    public ResponseEntity<?> getOrders(User user) {
        return ResponseEntity.ok(orderRepository.findAllByUser(user));
    }

    public ResponseEntity<?> deleteOrder(Long idOrder, User user) {
        String msg = "";
        try{
            orderRepository.deleteById(idOrder);
            msg ="Xóa Order thành công";
        }catch(Exception e){
            msg =e.toString();
        }
        return ResponseEntity.ok(msg);
    }
}
