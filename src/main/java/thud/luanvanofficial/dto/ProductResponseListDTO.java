package thud.luanvanofficial.dto;

import lombok.Data;
import thud.luanvanofficial.entity.Product;

import java.util.ArrayList;
import java.util.List;
@Data
public class ProductResponseListDTO {
    private List<Product> product = new ArrayList<>();
    private int total;

    public ProductResponseListDTO(List<Product> product, int total) {
        this.product = product;
        this.total = total;
    }
}

