package thud.luanvanofficial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import thud.luanvanofficial.entity.CartLine;
import thud.luanvanofficial.entity.User;
import java.util.List;

public class OrderDTO {
    @JsonProperty("fullname")
    private String deliveryName;
    @JsonProperty("address")
    private String deliveryAddress;
    @JsonProperty("phone")
    private String deliveryPhone;
    @JsonProperty("note")
    private String deliveryNote;
    private Long idCart;
    private List<CartLine> cartLines;

    public List<CartLine> getCartLines() {
        return cartLines;
    }

    public Long getIdCart() {
        return idCart;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    public String getDeliveryNote() {
        return deliveryNote;
    }

}
