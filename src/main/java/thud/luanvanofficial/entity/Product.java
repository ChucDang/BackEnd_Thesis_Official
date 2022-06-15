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
//    @Column(columnDefinition = "text")
    private String description;
//    @Column(columnDefinition = "decimal(1,2)")
    private float rate;

    private Boolean amortization;


    private String ram;
    private String memory;
    private String pin;
    private int battery_capacity;
    //Đặt tên thuộc tính là release thì sẽ ra lỗi nên đổi thành tên khác
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date release_date;
//@JsonFormat(pattern="yyyy-MM-dd")
//private Date birthday;
    private int warranty;
    private float weight;
    private String size;
    private int camera;
    private int selfie;
    @ManyToOne
    private Catergory catergory;
    @ManyToOne
    private CPU cpu;
    @ManyToOne
    private Screen screen;
}
