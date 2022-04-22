package thud.luanvanofficial.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gio_hang")
public class Gio_Hang extends BaseEntity{
    @ManyToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
    @OneToOne(mappedBy = "gio_hang")
    private User user;
}
