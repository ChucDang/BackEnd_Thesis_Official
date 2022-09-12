package thud.luanvanofficial.entity;
import javax.persistence.*;

@Entity
@Table(name = "brands")
public class Brand {
    @Id
    private String name;
    @ManyToOne
    private Category category;

    public Brand(String name, Category category) {
        this.name = name;
        this.category = category;
    }
    public Brand(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
    
}
