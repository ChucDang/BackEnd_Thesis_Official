package thud.luanvanofficial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartLineDTO {
    private Long productId;
    private byte amount;

    public Long getProductId() {
        return productId;
    }

    public byte getAmount() {
        return amount;
    }
}
