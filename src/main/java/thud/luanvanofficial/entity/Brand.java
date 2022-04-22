package thud.luanvanofficial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Brand")
public class Brand extends BaseEntity{
    @Column(columnDefinition = "nvarchar(10) not null")
    private String code;
    @OneToMany(mappedBy = "brand")
    private List<Product> products = new ArrayList<>();
}
