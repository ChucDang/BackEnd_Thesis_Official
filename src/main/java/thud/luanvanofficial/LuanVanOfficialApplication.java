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
            user.setPhone("0868285890");
            user.setEmail("Violympic1998@gmail.com");
            user.setGender(false);
            user.setAddress("Xã Định Hòa, Huyện Lai Vung, Đồng Tháp");
            Set<Authority> set = new HashSet<>();
            set.add(authorityRepository.getAuthorityByAuthority(Role_Enum.ROLE_ADMIN.toString()));
            user.setAuthorities(set);
            user.setPassword(passwordEncoder.getPasswordEncoder().encode("Alpha2398"));
            userRepository.save(user);
            User customer1 = new User();
            customer1.setId(2L);
            customer1.setFullname("Khách Hàng 1");
            customer1.setUsername("customer");
            customer1.setPhone("0868285890");
            customer1.setGender(true);
            customer1.setEmail("Chucb1706677@student.ctu.edu.vn");
            customer1.setAddress("Xã Định Hòa, Huyện Lai Vung, Đồng Tháp");
            Set<Authority> roles = new HashSet<>();
            roles.add(authorityRepository.getAuthorityByAuthority(Role_Enum.ROLE_CUSTOMER.toString()));
            customer1.setAuthorities(roles);
            customer1.setPassword(passwordEncoder.getPasswordEncoder().encode("Alpha2398"));
            userRepository.save(customer1);

            User _staff = new User();
            _staff.setId(2L);
            _staff.setFullname("Nhân Viên");
            _staff.setUsername("staff");
            _staff.setPhone("0868285890");
            _staff.setGender(true);
            _staff.setEmail("Chucb1706677@student.ctu.edu.vn");
            _staff.setAddress("Xã Định Hòa, Huyện Lai Vung, Đồng Tháp");
            Set<Authority> roles1 = new HashSet<>();
            roles1.add(authorityRepository.getAuthorityByAuthority(Role_Enum.ROLE_STAFF.toString()));
            _staff.setAuthorities(roles1);
            _staff.setPassword(passwordEncoder.getPasswordEncoder().encode("Alpha2398"));
            userRepository.save(_staff);
        };
    }
}
