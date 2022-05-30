package thud.luanvanofficial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import thud.luanvanofficial.entity.Brand;
import thud.luanvanofficial.entity.Catergory;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.repository.BrandRepository;
import thud.luanvanofficial.repository.CatergoryRepository;
import thud.luanvanofficial.repository.ProductRepository;
import thud.luanvanofficial.repository.UserRepository;
import thud.luanvanofficial.security.CustomPasswordEncoder;

@SpringBootApplication
public class LuanVanOfficialApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuanVanOfficialApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(BrandRepository brandRepository, CatergoryRepository catergoryRepository, ProductRepository productRepository, CustomPasswordEncoder passwordEncoder, UserRepository userRepository) { // user repo for ease of testing with a built-in user
        return args -> {
            Catergory phone = new Catergory("phone", "Điện Thoại Di Động");
            Catergory headphone = new Catergory("headphone", "Tai nghe");
            Catergory watch = new Catergory("watch", "Đồng Hồ");
            catergoryRepository.save(phone);
            catergoryRepository.save(headphone);
            catergoryRepository.save(watch);
            Brand samsung = new Brand("samsung","Đây là một sản phẩm samsung");
            Brand sony = new Brand("sony","Đây là một sản phẩm của Sony");
            brandRepository.save(samsung);
            brandRepository.save(sony);
            Product product_1 = new Product("Samsung Galaxy", 69.789f, 59.789f, "Đây là sản " +
                    "phẩm công ty Samsung nhé", 5.0f, true, phone, samsung);
            Product product_2 = new Product("Sony Experia", 70.789f, 99.789f, "Đây là sản " +
                    "phẩm công ty Sony nhé", 4.9f, true, phone, sony);
            productRepository.save(product_1);
            User user = new User();
            user.setId(1L);
            user.setUsername("chucdang");
            user.setPassword(passwordEncoder.getPasswordEncoder().encode("Alpha2398"));
            userRepository.save(user);

        };
    }
}
