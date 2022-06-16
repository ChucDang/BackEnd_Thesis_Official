package thud.luanvanofficial.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import thud.luanvanofficial.enums.Role_Enum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Authority")
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String authority;
//
//    @ManyToOne
//    @JsonIgnore
//    private User user;
    public Authority(String authority) {
        this.authority = authority;
    }

    public Authority() {

    }



    @Override
    public String getAuthority() {
        return authority;
    }
}
