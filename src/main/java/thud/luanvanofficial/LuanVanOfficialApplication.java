package thud.luanvanofficial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LuanVanOfficialApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuanVanOfficialApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner dataLoader(
//                                        CustomPasswordEncoder passwordEncoder,
//                                        UserRepository userRepository, AuthorityRepository authorityRepository
//    ) { // user repo for ease of testing with a built-in user
//        return args -> {
//            Authority admin= new Authority("ADMIN");
//            authorityRepository.save(admin);
//            User user = new User();
//            user.setId(1L);
//            user.setName("Đặng Văn Chức");
//            user.setUsername("admin");
//            Set<Authority> set = new HashSet<>();
//            set.add(admin);
//            user.setAuthorities(set);
//            user.setPassword(passwordEncoder.getPasswordEncoder().encode("Alpha2398"));
//            userRepository.save(user);
//        };
//    }
}
