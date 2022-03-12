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

    public San_Pham() {
    }

    public San_Pham(Doanh_Muc doanh_muc, String name, long old_price, long new_price, long stock, String description) {
        this.doanh_muc = doanh_muc;
        this.name = name;
        this.old_price = old_price;
        this.new_price = new_price;
        this.stock = stock;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Doanh_Muc getDoanh_muc() {
        return doanh_muc;
    }

    public void setDoanh_muc(Doanh_Muc doanh_muc) {
        this.doanh_muc = doanh_muc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOld_price() {
        return old_price;
    }

    public void setOld_price(long old_price) {
        this.old_price = old_price;
    }

    public long getNew_price() {
        return new_price;
    }

    public void setNew_price(long new_price) {
        this.new_price = new_price;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
