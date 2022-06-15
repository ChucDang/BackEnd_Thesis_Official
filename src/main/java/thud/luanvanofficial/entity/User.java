package thud.luanvanofficial.entity;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "Users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullname;
    private String address;
    private Boolean gender;
    private String phone;
    private String email;
    private String username;
    private String password;
    private String note;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();
    public User() {

    }

    @Override
    public Set<Authority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User(String fullname, String address, Boolean gender, String phone, String email, String username, String password, String note, Set<Authority> authorities) {
        this.fullname = fullname;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.note = note;
        this.authorities = authorities;
    }
}