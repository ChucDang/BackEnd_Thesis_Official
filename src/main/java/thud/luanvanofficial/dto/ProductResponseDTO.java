package thud.luanvanofficial.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.enums.Catergory_Enums;
import thud.luanvanofficial.enums.RAM_Enums;

@Data
public class ProductResponseDTO {
    private Product product;
    private Catergory_Enums[] list_catergory = Catergory_Enums.values();
    private RAM_Enums[] list_ram = RAM_Enums.values();

    public ProductResponseDTO(Product product) {
        this.product = product;
    }
}

