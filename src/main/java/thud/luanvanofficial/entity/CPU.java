package thud.luanvanofficial.entity;
import javax.persistence.*;

import thud.luanvanofficial.group_id.CPU_IDs;

@Entity
@Table(name = "cpus")
@IdClass(CPU_IDs.class)
public class CPU {
    @Id
    private String brand;
	@Id
    private String version;
    private int core;
    private String speed;
    private String max_speed;
    @Column(columnDefinition = "boolean default false")
    private Boolean sp_64bits;
    @Column(columnDefinition = "int default 0")
    private int thread;
    @Column(columnDefinition = "int default 0")
    private int buffer;
    @Column(columnDefinition = "int default 0",nullable = true)
    private int bus;

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	public int getCore() {
		return core;
	}
	public void setCore(int core) {
		this.core = core;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getMax_speed() {
		return max_speed;
	}
	public void setMax_speed(String max_speed) {
		this.max_speed = max_speed;
	}
	public Boolean getSp_64bits() {
		return sp_64bits;
	}
	public void setSp_64bits(Boolean sp_64bits) {
		this.sp_64bits = sp_64bits;
	}
	public int getThread() {
		return thread;
	}
	public void setThread(int thread) {
		this.thread = thread;
	}
	public int getBuffer() {
		return buffer;
	}
	public void setBuffer(int buffer) {
		this.buffer = buffer;
	}
	public int getBus() {
		return bus;
	}
	public void setBus(int bus) {
		this.bus = bus;
	}
    
}
