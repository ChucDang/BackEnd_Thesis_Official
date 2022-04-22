package thud.luanvanofficial.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doanh_muc")
public class Doanh_Muc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String doanh_muc_id;
    @Column(columnDefinition = "nvarchar(25) not null")
    private String name;
    @OneToMany(mappedBy = "catergory")
    private List<San_Pham> doanh_muc_sanphams= new ArrayList<>();
}
