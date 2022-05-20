package thud.luanvanofficial.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@Table(name = "Brand")
public class Brand {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "nvarchar(10) not null")
    private String code;

    public Brand(String code) {
        this.code = code;
    }
}
