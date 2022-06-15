package thud.luanvanofficial.service;


import org.springframework.beans.factory.annotation.Autowired;
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

    public void createUser(UserDTO userDto) {
        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setFullname(userDto.getFullname());
        newUser.setAddress(userDto.getAddress());
        newUser.setGender(true);
        newUser.setEmail(userDto.getEmail());
        newUser.setNote(userDto.getNote());
        String encodedPassword = customPasswordEncoder.getPasswordEncoder().encode(userDto.getPassword());
        newUser.setPassword(encodedPassword);
        Authority customer = new Authority(Role_Enum.ROLE_CUSTOMER.toString());
        Set<Authority> roles = new HashSet<>();
        roles.add(customer);
        newUser.setAuthorities(roles);
        authorityRepo.save(customer);
        userRepo.save(newUser);
    }

}
