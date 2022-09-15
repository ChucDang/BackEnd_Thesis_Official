package thud.luanvanofficial.entity;
import thud.luanvanofficial.service.Auditable;

import javax.persistence.*;

import java.sql.Date;



@Entity

@Table(name = "products")

public class Product extends Auditable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Brand brand;

    private String model;
    private float original_price;
    private float new_price;
    @Column(columnDefinition = "text")
    private String description;
    private float rate;
    @Column(columnDefinition = "integer default 0")
    private Long amount;

    private Boolean amortization;
    private String pin;

    private Date release_date;

    private int warranty;

    private String weight;
    private String size;
	@Column(columnDefinition = "text")
    private String camera;
    private String selfie;

    private String origin;
	@Column(columnDefinition = "text")
    private String graphic;
	@Column(columnDefinition = "text")
    private String material;
	@Column(columnDefinition = "text")
    private String video;
	@Column(columnDefinition = "text")
    private String feature;
    private String os;
    private int slot;
    private int remainSlot;
    private Boolean display;
    @ManyToOne
    private CPU cpu;
    @ManyToOne
    private Screen screen;
    @ManyToOne
    private RAM ram;
    @ManyToOne
    private Storage storage;
    @ManyToOne
    private Image image;
    @ManyToOne
    private Sale sale;
    @ManyToOne
    private Gift gift;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public float getOriginal_price() {
		return original_price;
	}
	public void setOriginal_price(float original_price) {
		this.original_price = original_price;
	}
	public float getNew_price() {
		return new_price;
	}
	public void setNew_price(float new_price) {
		this.new_price = new_price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Boolean getAmortization() {
		return amortization;
	}
	public void setAmortization(Boolean amortization) {
		this.amortization = amortization;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	public int getWarranty() {
		return warranty;
	}
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public String getSelfie() {
		return selfie;
	}
	public void setSelfie(String selfie) {
		this.selfie = selfie;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getGraphic() {
		return graphic;
	}
	public void setGraphic(String graphic) {
		this.graphic = graphic;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public int getRemainSlot() {
		return remainSlot;
	}
	public void setRemainSlot(int remainSlot) {
		this.remainSlot = remainSlot;
	}
	public Boolean getDisplay() {
		return display;
	}
	public void setDisplay(Boolean display) {
		this.display = display;
	}
	public CPU getCpu() {
		return cpu;
	}
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public RAM getRam() {
		return ram;
	}
	public void setRam(RAM ram) {
		this.ram = ram;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public Gift getGift() {
		return gift;
	}
	public void setGift(Gift gift) {
		this.gift = gift;
	}
    
}
