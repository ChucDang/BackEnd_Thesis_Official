package thud.luanvanofficial.dto;

import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.enums.Catergory_Enum;
import thud.luanvanofficial.enums.LaptopBrand_Enum;

public class ProductResponseDTO {
    private Product product;
    private Catergory_Enum[] product_enum = Catergory_Enum.values();

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Catergory_Enum[] getProduct_enum() {
        return product_enum;
    }

    public void setProduct_enum(Catergory_Enum[] product_enum) {
        this.product_enum = product_enum;
    }

    public ProductResponseDTO(Product product) {
        this.product = product;
    }
}
