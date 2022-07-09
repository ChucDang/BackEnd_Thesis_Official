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
    public Authority() {

    }

    public Authority(String toString) {
        this.authority = toString;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }


    public Authority(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }
}
