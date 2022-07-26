package thud.luanvanofficial.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<CartLine> cartLines;

    @OneToOne
    private User user;


    public Cart( User user) {
        this.user = user;
    }

    public Cart() {

    }
}
