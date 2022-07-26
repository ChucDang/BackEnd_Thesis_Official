package thud.luanvanofficial.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Table(name = "Invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Cart cart;
    private Boolean isPaid;

    public Invoice(Cart cart, Boolean isPaid) {
        this.cart = cart;
        this.isPaid = isPaid;
    }
}
