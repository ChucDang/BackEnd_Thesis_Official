package thud.luanvanofficial.dto;
import thud.luanvanofficial.entity.Invoice;
import thud.luanvanofficial.entity.Order;

import java.util.List;
public class CustomerOrdersResponse {
    private List<Order> orders;
    private List<Invoice> invoices;

    public CustomerOrdersResponse(List<Order> orders, List<Invoice> invoices) {
        this.orders = orders;
        this.invoices = invoices;
    }

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
    
}
