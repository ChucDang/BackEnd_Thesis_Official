package thud.luanvanofficial.entity;

import thud.luanvanofficial.dto.San_Pham_DTO;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class Hoa_Don extends BaseEntity{
    @OneToOne(mappedBy = "hoa_don")
    private Gio_Hang don_hang_gio_hang;
    @OneToMany(mappedBy = "hoa_don")
    private List<San_Pham_DTO> don_hang_sanphams;
}
