package thud.luanvanofficial.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doanh_muc")
public class Doanh_Muc extends BaseEntity {
    @Column(columnDefinition = "nvarchar(10) not null")
    private String code;
    @Column(columnDefinition = "nvarchar(25) not null")
    private String name;
    @OneToMany(mappedBy = "catergory")
    private List<Product> products = new ArrayList<>();
}
