package thud.luanvanofficial.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Invoice")
public class Invoice extends BaseEntity{
    @OneToOne(mappedBy = "cart")
    private Cart cart;
    @OneToMany(mappedBy = "invoice")
    private List<Product> products = new ArrayList<>();
}
