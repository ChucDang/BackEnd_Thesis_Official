package thud.luanvanofficial.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cart")
public class Cart extends BaseEntity{
    @ManyToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
    @OneToOne(mappedBy = "cart")
    private User user;
}
