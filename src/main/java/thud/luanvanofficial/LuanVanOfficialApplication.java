package thud.luanvanofficial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import thud.luanvanofficial.entity.Authority;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.enums.Role_Enum;
import thud.luanvanofficial.repository.AuthorityRepository;
import thud.luanvanofficial.repository.UserRepository;
import thud.luanvanofficial.util.CustomPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LuanVanOfficialApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuanVanOfficialApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner dataLoader(
//            CustomPasswordEncoder passwordEncoder,
//            UserRepository userRepository, AuthorityRepository authorityRepository
//    ) { // user repo for ease of testing with a built-in user
//        return args -> {
//            Authority admin= new Authority(Role_Enum.ROLE_ADMIN.toString());
//            authorityRepository.save(admin);
//            User user = new User();
//            user.setId(1L);
//            user.setFullname("Đặng Văn Chức");
//            user.setUsername("admin");
//            Set<Authority> set = new HashSet<>();
//            set.add(admin);
//            user.setAuthorities(set);
//            user.setPassword(passwordEncoder.getPasswordEncoder().encode("Alpha2398"));
//            userRepository.save(user);
//        };
//    }
}
