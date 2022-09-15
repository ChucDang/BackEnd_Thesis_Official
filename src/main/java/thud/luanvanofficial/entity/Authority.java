package thud.luanvanofficial.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "Authority")
public class Authority implements GrantedAuthority {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
