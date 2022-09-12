package thud.luanvanofficial.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.dto.CartLineDTO;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.service.CartService;
import thud.luanvanofficial.service.ProductService;

@RestController
@RequestMapping(path = "/cart")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class CartController {
    private CartService cartService;
    private ProductService productService;
    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }
    @PostMapping("addCart")
    public ResponseEntity<?> addCartItem(@RequestBody CartLineDTO cartLineDTO, @AuthenticationPrincipal User user){
        Product product = productService.findProductById(cartLineDTO.getProductId());
        return cartService.save(product, cartLineDTO.getAmount(), user);
    }
    @DeleteMapping("deleteCartItem/{idCartLine}")
    public ResponseEntity<?> deleteCartItem(@PathVariable Long idCartLine, @AuthenticationPrincipal User user){
        return cartService.delete(idCartLine, user);
    }
    @GetMapping
    public ResponseEntity<?> getAllCartLines(@AuthenticationPrincipal User user){
        return cartService.getAllCartLines(user);
    }
}
