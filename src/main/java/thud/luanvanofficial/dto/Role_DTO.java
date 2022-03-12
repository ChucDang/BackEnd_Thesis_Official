package thud.luanvanofficial.dto;
import java.util.List;

public class Role_DTO {
    private int role_id;
    private List<User_DTO> role_users;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public List<User_DTO> getRole_users() {
        return role_users;
    }

    public void setRole_users(List<User_DTO> role_users) {
        this.role_users = role_users;
    }
}
