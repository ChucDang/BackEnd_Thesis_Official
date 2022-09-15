package thud.luanvanofficial.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Entity
@Table(name = "Invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<InvoiceLine> invoiceLines = new ArrayList<>();
    private String deliveryName;
    private String deliveryAddress;
    private String deliveryPhone;
    private String deliveryNote;
    @OneToOne
    private User user;

    public Invoice(Order order) {
        // Vòng lặp chuyển OrderLine thành InvoiceLine
        ListIterator<OrderLine> listIterator = order.getOrderLines().listIterator();
        List<InvoiceLine> invoiceLineList = new ArrayList<>();
        while(listIterator.hasNext()){
            OrderLine temp = listIterator.next();
            InvoiceLine newInvoiceLine = new InvoiceLine();
            newInvoiceLine.setProduct(temp.getProduct());
            newInvoiceLine.setAmount(temp.getAmount());
            newInvoiceLine.setSale(temp.getSale());

            invoiceLineList.add(newInvoiceLine);
        }
        this.invoiceLines = invoiceLineList;
        this.user = order.getUser();
        this.deliveryAddress = order.getDeliveryAddress();
        this.deliveryNote = order.getDeliveryNote();
        this.deliveryPhone = order.getDeliveryPhone();
        this.deliveryName = order.getDeliveryName();
    }
    public Invoice(){}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<InvoiceLine> getInvoiceLines() {
		return invoiceLines;
	}
	public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
		this.invoiceLines = invoiceLines;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getDeliveryPhone() {
		return deliveryPhone;
	}
	public void setDeliveryPhone(String deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
	}
	public String getDeliveryNote() {
		return deliveryNote;
	}
	public void setDeliveryNote(String deliveryNote) {
		this.deliveryNote = deliveryNote;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
}
