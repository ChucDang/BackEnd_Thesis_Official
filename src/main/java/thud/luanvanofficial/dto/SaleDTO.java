package thud.luanvanofficial.dto;

import thud.luanvanofficial.entity.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleDTO {
    private Date start;
    private Date end;
    private String description;
    private List<Product> products = new ArrayList<Product>();
}
