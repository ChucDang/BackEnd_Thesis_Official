package thud.luanvanofficial.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "cartline")
public class CartLine {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private byte amount;
    @OneToOne
    private Product product;

    public CartLine(Product product, byte amount) {
        this.product = product;
        this.amount = amount;
    }
    public CartLine(){}
}
