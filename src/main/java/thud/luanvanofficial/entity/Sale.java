package thud.luanvanofficial.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Sale")
public class Sale extends BaseEntity{
    @Column(columnDefinition = "DATE")
    private Date start;
    @Column(columnDefinition = "DATE")
    private Date end;
    @Column(columnDefinition = "text")
    private String description;
    @OneToMany(mappedBy = "sale")
    private List<Product> products = new ArrayList<Product>();

}
