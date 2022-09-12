package thud.luanvanofficial.entity;


import javax.persistence.*;

@Entity

@Table(name = "orderline")
public class OrderLine {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private byte amount;
    @OneToOne
    private Product product;
    @OneToOne
    private Sale sale;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
    
}
