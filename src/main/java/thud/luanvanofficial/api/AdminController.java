package thud.luanvanofficial.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import thud.luanvanofficial.dto.MessageResponse;
import thud.luanvanofficial.dto.UserDTO;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.service.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    private UserService userService;
    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public ResponseEntity<?> getUsersByRole(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(userService.getAllUsersByRoles(user));
    }
    @DeleteMapping("/deleteAUser/{id}")
    public ResponseEntity<?> deleteAUser(@PathVariable Long id,@AuthenticationPrincipal User user){

        return userService.deleteAUser(id);
    }
    @PostMapping("/editAUser/{id}")
    public ResponseEntity<?> editAUser(@PathVariable Long id , @RequestBody UserDTO editValue, @AuthenticationPrincipal User user){
        return userService.editAUser(id,editValue,user);
    }
    @PostMapping("/addAUser")
    public ResponseEntity<?> addAUser(@RequestBody UserDTO userDTO, @AuthenticationPrincipal User user){
        Optional<User> existUser = userService.findUserByUsername(userDTO.getUsername());
        if(existUser.isEmpty()) 
        return userService.addAUser(userDTO);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse("Username đã tồn tại"));
    }



}
