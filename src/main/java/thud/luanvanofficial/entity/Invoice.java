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
//    @OneToOne(targetEntity=Cart.class)
//    private Cart cart;
//    @OneToMany(targetEntity=Product.class)
//    private List<Product> products = new ArrayList<>();
}
