package thud.luanvanofficial.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.dto.CartDTO;
import thud.luanvanofficial.dto.OrderDTO;
import thud.luanvanofficial.entity.Order;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.service.OrderService;

@RestController
@RequestMapping(path = "/order")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class OrderController {
    private OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("save")
    public ResponseEntity<?> saveOrder(@RequestBody OrderDTO orderDTO, @AuthenticationPrincipal User user){

        return  orderService.saveOrder(orderDTO, user);
    }
    @GetMapping()
    public ResponseEntity<?> getOrders(@AuthenticationPrincipal User user){
        return orderService.getOrders(user);
    }
    @DeleteMapping("delete/{idOrder}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long idOrder, @AuthenticationPrincipal User user){
        return orderService.deleteOrder(idOrder, user);
    }
}
