package thud.luanvanofficial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import thud.luanvanofficial.dto.CartDTO;
import thud.luanvanofficial.dto.MessageResponse;
import thud.luanvanofficial.entity.Cart;
import thud.luanvanofficial.entity.CartLine;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.repository.CartLineRepository;
import thud.luanvanofficial.repository.CartRepository;
import thud.luanvanofficial.util.ConsoleColors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private CartRepository cartRepository;
    private CartLineRepository cartLineRepository;

    @Autowired

    public CartService(CartRepository cartRepository, CartLineRepository cartLineRepository) {
        this.cartRepository = cartRepository;
        this.cartLineRepository = cartLineRepository;
    }


    public ResponseEntity<?> save(Product product, byte amount, User user) {
        CartLine cartLine = new CartLine(product, amount);
        Optional<Cart> cart = cartRepository.getByUser(user);
        List<CartLine> list_cartLines = new ArrayList<>();

        list_cartLines.add(cartLine);
        CartLine savedCartLine = cartLineRepository.save(cartLine);
        if (cart.isEmpty()) {
            Cart newCart = new Cart(user);
            newCart.setCartLines(list_cartLines);
            cartRepository.save(newCart);
            
        } else {
            list_cartLines.addAll(cart.get().getCartLines());

            cart.get().setCartLines(list_cartLines);

            cartRepository.save(cart.get());
           
        }
        return ResponseEntity.ok(savedCartLine) ;
    }

    public ResponseEntity<?> getAllCartLines(User user) {
        Optional<Cart> cart = cartRepository.getByUser(user);

        if (cart.isPresent()) {
            Long id = cart.get().getId();
            List<CartLine> list = cart.get().getCartLines();
            return ResponseEntity.ok(new CartDTO(id,list ));
        }
        return ResponseEntity.ok(new CartDTO());
    }

    public ResponseEntity<?> delete(Long idCartLine, User user) {
        try {
            Optional<Cart> cart = cartRepository.getByUser(user);
            List<CartLine> list_cartLines = new ArrayList<>();
            CartLine cartLine = cartLineRepository.getById(idCartLine);

            if (cart.get().getCartLines().size() == 1) {
                cartRepository.delete(cart.get());
                cartLineRepository.delete(cartLine);

            } else {

                Boolean result = cart.get().getCartLines().remove(cartLine);
                if (result) {
                    list_cartLines.addAll(cart.get().getCartLines());
                    cartLineRepository.delete(cartLine);
                    cartRepository.save(cart.get());
                }

            }
            return ResponseEntity.ok("1 dòng trong giỏ hàng được xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();

        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    public Optional<Cart> findById(Long idCart) {
        return cartRepository.findById(idCart);
    }
}