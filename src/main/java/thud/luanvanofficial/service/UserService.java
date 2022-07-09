package thud.luanvanofficial.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import thud.luanvanofficial.dto.UserDTO;
import thud.luanvanofficial.entity.Authority;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.enums.Role_Enum;
import thud.luanvanofficial.repository.AuthorityRepository;
import thud.luanvanofficial.repository.UserRepository;
import thud.luanvanofficial.util.CustomPasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
        newUser.setAddress(userDto.getAddress());
        newUser.setGender(true);
        newUser.setEmail(userDto.getEmail());
        newUser.setNote(userDto.getNote());
        String encodedPassword = customPasswordEncoder.getPasswordEncoder().encode(userDto.getPassword());
        newUser.setPassword(encodedPassword);
        Set<Authority> role = new HashSet<>();
        role.add(authorityRepo.getAuthorityByAuthority(Role_Enum.ROLE_CUSTOMER.toString()));
        newUser.setAuthorities(role);
        return userRepo.save(newUser);
    }
    public Set<User> getAllUsers(@AuthenticationPrincipal User user) {
        return userRepo.getAllUsers();
    }

}
