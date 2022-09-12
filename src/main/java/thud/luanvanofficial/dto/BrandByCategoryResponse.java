package thud.luanvanofficial.dto;
import thud.luanvanofficial.entity.Category;

import java.util.List;
public class BrandByCategoryResponse {
    private Category category;
    private List<String> brands;

    public BrandByCategoryResponse(Category category, List<String> brands) {
        this.category = category;
        this.brands = brands;
    }

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<String> getBrands() {
		return brands;
	}

	public void setBrands(List<String> brands) {
		this.brands = brands;
	}
    
}
