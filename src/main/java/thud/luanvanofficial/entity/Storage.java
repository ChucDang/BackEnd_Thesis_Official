package thud.luanvanofficial.entity;

import javax.persistence.*;

@Entity
@Table(name = "storages")
public class Storage {
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String code;
    private String storage;
    private String type;
    private Boolean supportOptane;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getSupportOptane() {
		return supportOptane;
	}
	public void setSupportOptane(Boolean supportOptane) {
		this.supportOptane = supportOptane;
	}
    
}
