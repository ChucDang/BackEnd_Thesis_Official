package thud.luanvanofficial.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@MappedSuperclass
//@ID khóa chính của BaseEntity sẽ là Khóa chính của các JPA entity kế thừa từ nó.
@EntityListeners(AuditingEntityListener.class)
//Spring Data cung cấp một hổ trợ phức tạp: @CreatedBy, @LastModifiedBy,....
public class BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @CreatedBy
    private String createdBy;
    @Column
    @CreatedDate
    private Date createdDate;
    @Column
    @LastModifiedBy
    private String modifyBy;
    @Column
    @LastModifiedDate
    private Date modifyDate;

}
