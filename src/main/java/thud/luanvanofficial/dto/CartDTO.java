package thud.luanvanofficial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import thud.luanvanofficial.entity.CartLine;

import java.util.List;

public class CartDTO {
    @JsonProperty("idCart")
    private Long idCart;
    @JsonProperty("cartLineList")
    private List<CartLine> cartLineList;

    public CartDTO(Long idCart, List<CartLine> cartLineList) {
        this.idCart = idCart;
        this.cartLineList = cartLineList;
    }

    public CartDTO() {

    }

    public Long getIdCart() {
        return idCart;
    }

    public List<CartLine> getCartLineList() {
        return cartLineList;
    }
}
