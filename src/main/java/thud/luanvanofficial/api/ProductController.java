package thud.luanvanofficial.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.dto.ProductResponseDTO;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.Catergory;
import thud.luanvanofficial.repository.catalogRepo.CatergoryRepository;
import thud.luanvanofficial.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CatergoryRepository catergoryRepository;

    @GetMapping("/catergory/{code}")
    public ResponseEntity<?> getProductByCatergoryCode(@PathVariable String code) {
        Optional<Catergory> catergory = catergoryRepository.findByCode(code);
        List<Product> products = productService.findAllByCatergory(catergory);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Optional<Product> optproduct = productService.findById(id);
        return ResponseEntity.ok( new ProductResponseDTO(optproduct.orElse(new Product())));
    }

//    @PostMapping(consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Product postProduct(@RequestBody Product product) {
//        return repository.save(product);
//    }
//    @PutMapping
//    public Product putProduct(@RequestBody Product product) {
//        return repository.save(product);
//    }
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteProduct(@PathVariable("id") Long id) {
//        try {
//            repository.deleteById(id);
//            System.out.println("Xóa thành công");
//        } catch (EmptyResultDataAccessException e) {
//            System.out.println("Xóa thất bại");
//        }
//    }
}
