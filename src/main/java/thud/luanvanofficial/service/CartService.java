package thud.luanvanofficial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import thud.luanvanofficial.entity.Cart;
import thud.luanvanofficial.entity.Order;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.repository.OrderRepository;
import thud.luanvanofficial.repository.CartRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private CartRepository cartRepository;
    private OrderRepository orderRepository;

    @Autowired

    public CartService(CartRepository cartRepository, OrderRepository orderRepository) {
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
    }


    public ResponseEntity<?> save(Product product, byte amount, User user) {
        Order order = new Order(product, amount);
        Optional<Cart> cart = cartRepository.getByUser(user);
        List<Order> list_orders = new ArrayList<>();

        list_orders.add(order);
        orderRepository.save(order);
        if (cart.isEmpty()) {
            Cart newCart = new Cart(user);
            newCart.setOrders(list_orders);
            cartRepository.save(newCart);
        } else {
            list_orders.addAll(cart.get().getOrders());

            cart.get().setOrders(list_orders);

            cartRepository.save(cart.get());

        }
        return ResponseEntity.ok(new Cart());
    }

    public List<Order> getAllOrders(User user) {
        Optional<Cart> cart = cartRepository.getByUser(user);
        if (cart.isPresent()) {
            return cart.get().getOrders();
        }
        return new ArrayList<>();
    }

    public ResponseEntity<?> delete(Long idcartItem, User user) {
        try {
            Optional<Cart> cart = cartRepository.getByUser(user);
            List<Order> list_orders = new ArrayList<>();
            Order order = orderRepository.getById(idcartItem);
            if (cart.get().getOrders().size() == 1) {
                cartRepository.delete(cart.get());
                orderRepository.delete(order);

            } else {

                Boolean result = cart.get().getOrders().remove(order);
                if (result) {
                    list_orders.addAll(cart.get().getOrders());
                    orderRepository.delete(order);
                    cartRepository.save(cart.get());
                }

            }
            return ResponseEntity.ok("Order được xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();

        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}