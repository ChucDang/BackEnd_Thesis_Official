package thud.luanvanofficial.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
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
}
