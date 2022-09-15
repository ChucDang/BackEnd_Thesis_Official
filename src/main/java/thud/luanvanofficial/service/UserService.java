package thud.luanvanofficial.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import thud.luanvanofficial.dto.MessageResponse;
import thud.luanvanofficial.dto.UserDTO;
import thud.luanvanofficial.entity.Authority;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.enums.Role_Enum;
import thud.luanvanofficial.repository.AuthorityRepository;
import thud.luanvanofficial.repository.UserRepository;
import thud.luanvanofficial.util.ConsoleColors;
import thud.luanvanofficial.util.CustomPasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.security.AuthCredentialsRequest;
import thud.luanvanofficial.util.JwtUtil;

@Service
public class UserService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepo;

    private AuthorityRepository authorityRepo;

    private CustomPasswordEncoder customPasswordEncoder;
  
    private JwtUtil jwtUtil;

    @Autowired
    public UserService(AuthenticationManager authenticationManager, UserRepository userRepo,
            AuthorityRepository authorityRepo, CustomPasswordEncoder customPasswordEncoder,
            JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.authorityRepo = authorityRepo;
        this.customPasswordEncoder = customPasswordEncoder;
    
        this.jwtUtil = jwtUtil;
    }

    public ResponseEntity<?> changePassword(String currentPassword, String newPassword, User user) {
        String encodedNewPassword = customPasswordEncoder.getPasswordEncoder().encode(newPassword);
        if (customPasswordEncoder.getPasswordEncoder().matches(currentPassword, user.getPassword())) {
            user.setPassword(encodedNewPassword);
            User savedUser = userRepo.save(user);
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtUtil.generateToken(savedUser)).body(savedUser);
           
        } else {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(new MessageResponse("Password đang sử dụng không đúng"));
        }

    }

    public Optional<User> findUserByUsername(String username) {
        return Optional.ofNullable(userRepo.findByUsername(username));
    }

    public User createACustomer(UserDTO userDto) {
        User newUser = new User();

        newUser.setUsername(userDto.getUsername());

        newUser.setEnabled(true);
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

    public ResponseEntity<?> deleteAUser(Long idUser) {

        try {
            userRepo.deleteById(idUser);

        } catch (Exception e) {
            return ResponseEntity.ok(new MessageResponse("Xóa User thất bại!!!"));
        }
        return ResponseEntity.ok(new MessageResponse("Xóa User thành công"));
    }

    public Set<User> getAllUsersByRoles(@AuthenticationPrincipal User user) {
        Authority staff = authorityRepo.getAuthorityByAuthority(Role_Enum.ROLE_STAFF.toString());
        Authority admin = authorityRepo.getAuthorityByAuthority(Role_Enum.ROLE_ADMIN.toString());
        Set<User> allUsers = userRepo.getAllUsers();
        Set<User> selectedUser = allUsers.stream()
                .filter(p -> p.getAuthorities().contains(staff)
                        || p.getAuthorities().contains(admin))
                .collect(Collectors.toSet());
        return selectedUser;
    }

    public ResponseEntity<?> editAUser(Long id, UserDTO edit, User user) {

        Optional<User> currentUser = userRepo.findById(id);
        if (currentUser.isPresent()) {
            Authority newAuthority = authorityRepo.getAuthorityByAuthority(edit.getAuthority());
            Set<Authority> newRoles = new HashSet<>();
            newRoles.add(newAuthority);
            currentUser.get().setAuthorities(newRoles);
            currentUser.get().setEnabled(edit.getEnabled());
            userRepo.save(currentUser.get());

        }
        // trả về danh sách Customer và admin
        return ResponseEntity.ok(this.getAllUsersByRoles(user));

    }

    public ResponseEntity<?> addAUser(UserDTO userDTO) {

        User newUser = new User();
        ModelMapper modelMapper = new ModelMapper();
        newUser = modelMapper.map(userDTO, User.class);
        Authority newAuthority = authorityRepo.getAuthorityByAuthority(userDTO.getAuthority());
        Set<Authority> newSetRoles = new HashSet<Authority>();
        newSetRoles.add(newAuthority);
        newUser.setAuthorities(newSetRoles);
        String encodedPassword = customPasswordEncoder.getPasswordEncoder().encode(userDTO.getPassword());
        newUser.setPassword(encodedPassword);
        User savedUser = userRepo.save(newUser);
        return ResponseEntity.ok(savedUser);

    }

    public ResponseEntity<?> changeInfoUser(UserDTO userDTO, User user) {
        ModelMapper modelMapper = new ModelMapper();

        User newUser = modelMapper.map(userDTO, User.class);
        // Để đảm bảo User không thể tự thay đổi Authority, Enable và Id của mình
        newUser.setId(user.getId());
        newUser.setAuthorities(user.getAuthorities());
        newUser.setEnabled(user.getEnabled());
        newUser.setPassword(user.getPassword());
        try{
            User savedUser = userRepo.save(newUser);
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtUtil.generateToken(savedUser)).body(savedUser);

        }catch(Exception e){
          return  ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse(e.toString()));
        }
       
    }
}
