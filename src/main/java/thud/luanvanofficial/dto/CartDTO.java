package thud.luanvanofficial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import thud.luanvanofficial.entity.CartLine;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {
    @JsonProperty("idCart")
    private Long idCart;
    @JsonProperty("cartLines")
    private List<CartLine> cartLines = new ArrayList<>();

    public CartDTO(Long idCart, List<CartLine> cartLines) {
        this.idCart = idCart;
        this.cartLines = cartLines;
    }

    public CartDTO() {
        
    }

    public Long getIdCart() {
        return idCart;
    }

    public void setIdCart(Long idCart) {
        this.idCart = idCart;
    }

    public List<CartLine> getCartLines() {
        return cartLines;
    }

    public void setCartLines(List<CartLine> cartLines) {
        this.cartLines = cartLines;
    }
}
