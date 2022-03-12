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

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public San_Pham getSan_pham() {
        return san_pham;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSan_pham(San_Pham san_pham) {
        this.san_pham = san_pham;
    }

    public float getRate_sale() {
        return rate_sale;
    }

    public void setRate_sale(float rate_sale) {
        this.rate_sale = rate_sale;
    }

    public Date getStart_Sale_Date() {
        return start_Sale_Date;
    }

    public void setStart_Sale_Date(Date start_Sale_Date) {
        this.start_Sale_Date = start_Sale_Date;
    }

    public Date getEnd_Sale_Date() {
        return end_Sale_Date;
    }

    public void setEnd_Sale_Date(Date end_Sale_Date) {
        this.end_Sale_Date = end_Sale_Date;
    }
}
