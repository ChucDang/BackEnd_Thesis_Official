package thud.luanvanofficial.entity;
import thud.luanvanofficial.service.Auditable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cart")
public class Cart extends Auditable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER)
    private List<CartLine> cartLines;
    @OneToOne
    private User user;


    public Cart( User user) {
        this.user = user;
    }

    public Cart() {

    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CartLine> getCartLines() {
		return cartLines;
	}

	public void setCartLines(List<CartLine> cartLines) {
		this.cartLines = cartLines;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}
