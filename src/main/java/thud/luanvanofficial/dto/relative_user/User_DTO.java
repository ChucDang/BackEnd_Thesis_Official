package thud.luanvanofficial.dto.relative_user;

import thud.luanvanofficial.dto.enums.Role_Enum;

import java.util.Date;

public class User_DTO {
    private long user_id;
    private String name;
    private String address;
    private Date birthday;
    private Boolean sex;
    private String avatar_url;
    private String phone;
    private String email;
    private Role_Enum role;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role_Enum getRole() {
        return role;
    }

    public void setRole(Role_Enum role) {
        this.role = role;
    }
}
