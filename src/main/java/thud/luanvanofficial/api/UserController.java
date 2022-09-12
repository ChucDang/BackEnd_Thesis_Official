package thud.luanvanofficial.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import thud.luanvanofficial.dto.MessageResponse;
import thud.luanvanofficial.dto.UserDTO;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.service.UserService;
import thud.luanvanofficial.util.ConsoleColors;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/auth/users")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    private ResponseEntity<?> createACustomer(@RequestBody UserDTO userDto) {
        Optional<User> existUser = userService.findUserByUsername(userDto.getUsername());
        System.out.println( ConsoleColors.GREEN + "userDto "+ userDto.getFullname() + ' ' + userDto.getPassword() +ConsoleColors.RESET);

        if(existUser.isEmpty()){
            userService.createACustomer(userDto);

            
                return ResponseEntity.ok(new MessageResponse("Đăng ký thành công"));
                       
        }
        return ResponseEntity.badRequest().body(new MessageResponse("Username đã tồn tại!!!"));
    }
    @PostMapping("changePassword")
    public ResponseEntity<?> changePassword(@RequestParam String currentPassword, @RequestParam String newPassword, @AuthenticationPrincipal User user){
        return userService.changePassword(currentPassword, newPassword, user);
    }
    @PostMapping("changeInfoUser")
    public ResponseEntity<?> changeInfoUser(@RequestBody UserDTO userDTO, @AuthenticationPrincipal User user){
        return userService.changeInfoUser(userDTO, user);
    }
}
