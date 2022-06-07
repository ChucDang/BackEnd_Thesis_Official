//package thud.luanvanofficial.api;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import thud.luanvanofficial.entity.User;
//import thud.luanvanofficial.repository.BrandRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AssignmentService {
//    @Autowired
//    private BrandRepository brandRepository;
//    public Brand save(User user) {
//        Brand test = new Brand("TEST", "Đây là TEST");
//        return brandRepository.save(test);
//    }
//    public Brand save(Brand brand) {
//        return brandRepository.save(brand);
//    }
//    public List<Brand> findAll(User user){
//        return brandRepository.findAll();
//    }
//    public Optional<Brand> findByCode(String id){
//        return brandRepository.findByCode(id);
//    }
//
//}
