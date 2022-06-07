package thud.luanvanofficial.api;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thud.luanvanofficial.entity.Authority;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.repository.AuthorityRepository;
import thud.luanvanofficial.repository.UserRepository;

import java.util.Set;

@RestController
@RequestMapping(path = "/users", produces = "application/json")
public class UserController {
    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;

    public UserController(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

//    @PutMapping
//    public Product putUser(@RequestBody User data) {
//            User user = new User();
//            user.setId(1L);
//            user.setName("Đặng Văn Chức");
//            user.setUsername("admin");
//            Set<Authority> set = new HashSet<>();
//            set.add(admin);
//            user.setAuthorities(set);
//            user.setPassword(passwordEncoder.getPasswordEncoder().encode("Alpha2398"));
//            userRepository.save(user);

}
