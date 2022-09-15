package thud.luanvanofficial.entity;
import javax.persistence.*;



@Entity
@Table(name = "cartline")
public class CartLine {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private byte amount;
    @OneToOne
    private Product product;


    public CartLine(Product product, byte amount) {
        this.product = product;
        this.amount = amount;
    }
    public CartLine(){}

	public byte getAmount() {
		return amount;
	}
	public void setAmount(byte amount) {
		this.amount = amount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

    
    
}
