package thud.luanvanofficial.dto;

import lombok.Data;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.enums.Laptop_Enums;
import thud.luanvanofficial.enums.RAM_Enums;

@Data
public class ProductResponseDTO {
    private Product product;
    private Laptop_Enums[] list_catergory = Laptop_Enums.values();
    private RAM_Enums[] list_ram = RAM_Enums.values();

    public ProductResponseDTO(Product product) {
        this.product = product;
    }
}

