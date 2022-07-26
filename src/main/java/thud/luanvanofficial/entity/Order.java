package thud.luanvanofficial.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String deliveryName;
    private String deliveryAddress;
    private String deliveryPhone;
    private String deliveryNote;
    @OneToMany
    private List<CartLine> cartLines = new ArrayList<>();

    @OneToOne
    private User user;

    public Order(String deliveryName, String deliveryAddress, String deliveryPhone, String deliveryNote, List<CartLine> cartLines, User user) {
        this.deliveryName = deliveryName;
        this.deliveryAddress = deliveryAddress;
        this.deliveryPhone = deliveryPhone;
        this.deliveryNote = deliveryNote;
        this.cartLines = cartLines;
        this.user = user;
    }

    public Order(){

    }
}
