package thud.luanvanofficial.dto;

import thud.luanvanofficial.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductResponseListDTO {
    private List<Product> products = new ArrayList<>();
    private int total;

    public ProductResponseListDTO(List<Product> products, int total) {
        this.products = products;
        this.total = total;
    }

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
    
}

