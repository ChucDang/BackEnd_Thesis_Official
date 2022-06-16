package thud.luanvanofficial.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//import java.sql.Date;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
//    @Column(columnDefinition = "nvarchar(25) not null")
    private String brand;
    private String model;
//    @Column(columnDefinition = "decimal(15) not null")
    private float original_price;
//    @Column(columnDefinition = "decimal(15) not null")
    private float new_price;
    @Column(columnDefinition = "text")
    private String description;
//    @Column(columnDefinition = "decimal(1,2)")
    private float rate;

    private Boolean amortization;
    private String pin;
    private String battery_capacity;
    //Đặt tên thuộc tính là release thì sẽ ra lỗi nên đổi thành tên khác
    @JsonFormat(pattern = "MM/dd/yyyy")
    @Column(columnDefinition = "Date")
    private Date release_date;

    private int warranty;

    private String weight;
    private String size;
    private String camera;
    private String selfie;

    private String origin;
    private String graphic;
    private String material;
    private String video;
    private String feature;
    private String os;
    @ManyToOne
    private Catergory catergory;
    @ManyToOne
    private CPU cpu;
    @ManyToOne
    private Screen screen;
    @ManyToOne
    private RAM ram;
    @ManyToOne
    private Storage storage;

}
