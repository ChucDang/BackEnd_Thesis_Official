package thud.luanvanofficial.api;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.dto.ProductResponseDTO;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path = "/products", produces = "application/json")
//@CrossOrigin(origins = "*")
public class ProductController {
    private ProductRepository repository;
    public ProductController(ProductRepository tacoRepo) {
        repository = tacoRepo;
    }
    @GetMapping
    public ResponseEntity<?> allProducts() {
        List<Product> products = repository.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Optional<Product> optproduct = repository.findById(id);
        return ResponseEntity.ok( new ProductResponseDTO(optproduct.orElse(new Product())));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Product postProduct(@RequestBody Product product) {
        return repository.save(product);
    }
    @PutMapping
    public Product putProduct(@RequestBody Product product) {
        return repository.save(product);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id) {
        try {
            repository.deleteById(id);
            System.out.println("Xóa thành công");
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Xóa thất bại");
        }
    }
}
