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

    @Bean
    public CommandLineRunner dataLoader(
            CustomPasswordEncoder passwordEncoder,
            UserRepository userRepository, AuthorityRepository authorityRepository
    ) { // user repo for ease of testing with a built-in user
        return args -> {
            Authority admin= new Authority(Role_Enum.ROLE_ADMIN.toString());
            Authority customer= new Authority(Role_Enum.ROLE_CUSTOMER.toString());
            Authority staff= new Authority(Role_Enum.ROLE_STAFF.toString());
            authorityRepository.save(admin);
            authorityRepository.save(customer);
            authorityRepository.save(staff);
            User user = new User();
            user.setId(1L);
            user.setFullname("Đặng Văn Chức");
            user.setUsername("admin");
            Set<Authority> set = new HashSet<>();
            set.add(authorityRepository.getAuthorityByAuthority(Role_Enum.ROLE_ADMIN.toString()));
            user.setAuthorities(set);
            user.setPassword(passwordEncoder.getPasswordEncoder().encode("Alpha2398"));
            userRepository.save(user);
            User customer1 = new User();
            customer1.setId(2L);
            customer1.setFullname("Khách Hàng 1");
            customer1.setUsername("customer");
            Set<Authority> roles = new HashSet<>();
            roles.add(authorityRepository.getAuthorityByAuthority(Role_Enum.ROLE_ADMIN.toString()));
            customer1.setAuthorities(roles);
            customer1.setPassword(passwordEncoder.getPasswordEncoder().encode("Alpha2398"));
            userRepository.save(customer1);
        };
    }
}
