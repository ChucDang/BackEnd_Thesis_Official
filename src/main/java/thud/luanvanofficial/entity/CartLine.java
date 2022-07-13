package thud.luanvanofficial.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private byte amount;
    @OneToOne
    private Product product;

    public Order(Product product, byte amount) {
        this.product = product;
        this.amount = amount;
    }
    public Order(){}
}
