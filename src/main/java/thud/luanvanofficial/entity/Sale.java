package thud.luanvanofficial.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Sale")
public class Sale {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "DATE")
    private Date start;
    @Column(columnDefinition = "DATE")
    private Date end;
    @Column(columnDefinition = "text")
    private String description;
    @OneToMany
    private List<Product> products = new ArrayList<Product>();

}
