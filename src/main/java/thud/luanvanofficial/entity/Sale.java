package thud.luanvanofficial.entity;
import thud.luanvanofficial.service.Auditable;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Sale")
public class Sale extends Auditable {
    @Id
    private String code;
    private Long percentOff;
    private Date start;
    private Date end;
    private Long larger_than;
    private Boolean apply_all;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getPercentOff() {
		return percentOff;
	}
	public void setPercentOff(Long percentOff) {
		this.percentOff = percentOff;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Long getLarger_than() {
		return larger_than;
	}
	public void setLarger_than(Long larger_than) {
		this.larger_than = larger_than;
	}
	public Boolean getApply_all() {
		return apply_all;
	}
	public void setApply_all(Boolean apply_all) {
		this.apply_all = apply_all;
	}
    
}
