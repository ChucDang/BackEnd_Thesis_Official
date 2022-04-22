package thud.luanvanofficial.dto;


import java.util.List;

public class Product_DTO extends AbstractDTO<Product_DTO>{
    private long id;
    private String name;
    private float original_price;
    private float new_price;
    private String description;
    private float rate;
    private List<String> image_urls;
    private String brand;
    private Boolean amortization;
    private String category;
    private String sale;
}
