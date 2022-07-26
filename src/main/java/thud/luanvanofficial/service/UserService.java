package thud.luanvanofficial.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import thud.luanvanofficial.dto.UserDTO;
import thud.luanvanofficial.entity.Authority;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.enums.Role_Enum;
import thud.luanvanofficial.repository.AuthorityRepository;
import thud.luanvanofficial.repository.UserRepository;
import thud.luanvanofficial.util.CustomPasswordEncoder;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private AuthorityRepository authorityRepo;
    @Autowired
    private CustomPasswordEncoder customPasswordEncoder;

    public Optional<User> findUserByUsername(String username) {
        return Optional.ofNullable(userRepo.findByUsername(username));
    }

    public User createUser(UserDTO userDto) {
        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setFullname(userDto.getFullname());
        newUser.setPhone(userDto.getPhone());
        newUser.setAddress(userDto.getAddress());
        newUser.setGender(userDto.getGender());
        newUser.setEmail(userDto.getEmail());
        newUser.setNote(userDto.getNote());
        String encodedPassword = customPasswordEncoder.getPasswordEncoder().encode(userDto.getPassword());
        newUser.setPassword(encodedPassword);
        Set<Authority> role = new HashSet<>();
        role.add(authorityRepo.getAuthorityByAuthority(Role_Enum.ROLE_CUSTOMER.toString()));
        newUser.setAuthorities(role);
        return userRepo.save(newUser);
    }
    public ResponseEntity<?> deleteAUser(Long idUser){
        String msg;
        try{
            userRepo.deleteById(idUser);
            msg = "User được xóa thành công";
        }catch (Exception e){
            msg = "Lỗi! User chưa được xóa";
        }
        return ResponseEntity.ok(msg);
    }
    public Set<User> getAllUsersByRoles(@AuthenticationPrincipal User user) {
        Authority staff = authorityRepo.getAuthorityByAuthority(Role_Enum.ROLE_STAFF.toString());
        Authority admin = authorityRepo.getAuthorityByAuthority(Role_Enum.ROLE_ADMIN.toString());
        Set<User> allUsers = userRepo.getAllUsers();
        Set<User> CustomerUser = allUsers.stream()
                .filter(p -> p.getAuthorities().contains(staff) || p.getAuthorities().contains(admin)).collect(Collectors.toSet());
        return CustomerUser;
    }

}
