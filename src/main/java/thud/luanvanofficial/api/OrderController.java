package thud.luanvanofficial.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.dto.OrderDTO;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.service.OrderService;
import thud.luanvanofficial.util.ConsoleColors;

import javax.annotation.security.RolesAllowed;

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
        System.out.println( ConsoleColors.GREEN + "orderDTO "+ orderDTO.getOrderLines().toString() +ConsoleColors.RESET);

        return  orderService.saveOrder(orderDTO, user);
    }
    @GetMapping()
    public ResponseEntity<?> getOrders(@AuthenticationPrincipal User user){
        return orderService.getOrders(user);
    }
    @DeleteMapping("delete/{idOrder}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long idOrder, @AuthenticationPrincipal User user){
        return orderService.deleteOrder(idOrder);
    }

    @GetMapping("/customerOrders")
    @RolesAllowed({"ROLE_STAFF","ROLE_ADMIN"})
    public ResponseEntity<?> getAllCustomerOrders(@AuthenticationPrincipal User user){
        return orderService.getAllCustomerOrders();
    }

    @PostMapping("/editStatusOrder/{id}/{status}")
    @RolesAllowed({"ROLE_STAFF","ROLE_ADMIN"})
    public ResponseEntity<?> editStatusOrder(@PathVariable Long id, @PathVariable String status, @AuthenticationPrincipal User user){
        return orderService.editStatusOrder(id, status);
    }
}
