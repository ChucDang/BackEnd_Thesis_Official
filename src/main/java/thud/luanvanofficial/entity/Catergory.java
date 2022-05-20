package thud.luanvanofficial.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "Catergory")
public class Catergory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "nvarchar(10) not null")
    private String code;
    @Column(columnDefinition = "nvarchar(25) not null")
    private String name;

    public Catergory(String code, String name) {
        this.code=code;
        this.name=name;
    }
}
