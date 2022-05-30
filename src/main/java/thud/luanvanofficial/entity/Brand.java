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
    private int  id;
    private String code;
    private String name;
    public Brand(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
