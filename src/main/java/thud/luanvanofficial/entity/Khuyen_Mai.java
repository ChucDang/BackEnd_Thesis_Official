package thud.luanvanofficial.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "khuyen_mai")
public class Khuyen_Mai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @ManyToOne
    @JoinColumn(name = "san_pham_id")
    private San_Pham san_pham;
    @Column(nullable = false, unique = true, length = 25)
    private String caption;
    @Column(nullable = false, unique = false, length = 250)
    private String description;
    private float rate_sale;
    private Date start_Sale_Date, end_Sale_Date;

    public Khuyen_Mai() {
    }

    public Khuyen_Mai(San_Pham san_pham, String caption, String description, float rate_sale, Date start_Sale_Date, Date end_Sale_Date) {
        this.san_pham = san_pham;
        this.caption = caption;
        this.description = description;
        this.rate_sale = rate_sale;
        this.start_Sale_Date = start_Sale_Date;
        this.end_Sale_Date = end_Sale_Date;
    }
}
