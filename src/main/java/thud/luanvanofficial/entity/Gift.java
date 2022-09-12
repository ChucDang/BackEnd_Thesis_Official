package thud.luanvanofficial.entity;
import thud.luanvanofficial.service.Auditable;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Gift")
public class Gift extends Auditable {
    @Id
    private String code;
    private Date start;
    private Date end;
    private String list_gifts;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public String getList_gifts() {
		return list_gifts;
	}
	public void setList_gifts(String list_gifts) {
		this.list_gifts = list_gifts;
	}
    
}
