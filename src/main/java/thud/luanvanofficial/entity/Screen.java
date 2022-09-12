package thud.luanvanofficial.entity;

import javax.persistence.*;

@Entity
@Table(name = "screens")
public class Screen {
    @Id
    private int id;
    private String size;
    private String tech;
    private String resolution;
    private String color;
    private int frequent;
    private String material;
    private String standard;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getFrequent() {
		return frequent;
	}
	public void setFrequent(int frequent) {
		this.frequent = frequent;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
    
}
