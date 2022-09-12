package thud.luanvanofficial.entity;
import thud.luanvanofficial.service.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "Stock")
public class Stock extends Auditable {
    
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    private Long price;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Stores stores;
    private Long amount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Stores getStores() {
		return stores;
	}
	public void setStores(Stores stores) {
		this.stores = stores;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
    
}
