package thud.luanvanofficial.dto.relative_user;

import thud.luanvanofficial.dto.enums.Role_Enum;

import java.util.Date;

public class User_DTO {
    private long id;
    private String name;
    private String address;
    private Date birthday;
    private Boolean sex;
    private String avatar_url;
    private String phone;
    private String email;
    private Role_Enum role;
}
