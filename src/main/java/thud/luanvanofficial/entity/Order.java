package thud.luanvanofficial.entity;


import thud.luanvanofficial.dto.OrderDTO;
import thud.luanvanofficial.enums.OrderStatus_Enum;
import thud.luanvanofficial.service.Auditable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order extends Auditable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String deliveryName;
    private String deliveryAddress;
    private String deliveryPhone;
    private String deliveryNote;
    private String status;
    @OneToMany
    private List<OrderLine> orderLines = new ArrayList<>();

    @OneToOne
    private User user;


    public Order(OrderDTO orderDTO){
        this.deliveryName = orderDTO.getDeliveryName();
        this.deliveryAddress = orderDTO.getDeliveryAddress();
        this.deliveryPhone = orderDTO.getDeliveryPhone();
        this.deliveryNote = orderDTO.getDeliveryNote();
        this.status = OrderStatus_Enum.Waiting.toString();
    }

    public Order(){
        this.status = OrderStatus_Enum.Waiting.toString();

    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}
