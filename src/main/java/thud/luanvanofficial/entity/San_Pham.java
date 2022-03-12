package thud.luanvanofficial.entity;
import javax.persistence.*;

@Entity
@Table(name = "san_pham")
public class San_Pham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "doanh_muc_id")
    private Doanh_Muc doanh_muc;
    @Column(nullable = false, length = 25)
    private String name;
    private long old_price;
    private long new_price;
    private long stock;
    private String description;
    private float rate;
}
