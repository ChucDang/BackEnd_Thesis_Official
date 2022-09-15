package thud.luanvanofficial.entity;


import javax.persistence.*;

@Entity
@Table(name = "rams")
public class RAM {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String type;
    private int storage;
    //Tốc độ RAM
    private float speed;
    private float supportMaxSpeed;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float getSupportMaxSpeed() {
		return supportMaxSpeed;
	}
	public void setSupportMaxSpeed(float supportMaxSpeed) {
		this.supportMaxSpeed = supportMaxSpeed;
	}

    
}
