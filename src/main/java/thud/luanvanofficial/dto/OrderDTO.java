package thud.luanvanofficial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import thud.luanvanofficial.entity.OrderLine;
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
    @JsonProperty("orderLines")
    private List<OrderLine> orderLines;



    public List<OrderLine> getOrderLines() {
        return orderLines;
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
