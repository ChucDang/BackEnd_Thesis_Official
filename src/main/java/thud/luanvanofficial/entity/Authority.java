package thud.luanvanofficial.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

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
    @OneToMany
    private List<User> users = new ArrayList<>();

    public Authority(String authority) {
        this.authority = authority;
    }

    public Authority() {

    }

    @Override
    public String getAuthority() {
        return null;
    }
}
