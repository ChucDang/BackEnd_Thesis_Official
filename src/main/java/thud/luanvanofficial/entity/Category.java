package thud.luanvanofficial.entity;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@CrossOrigin(origins = "*")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    public Category() {
		// TODO Auto-generated method stub

	}
    public Category(String code, String name) {
        this.code = code;
        this.name = name;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
