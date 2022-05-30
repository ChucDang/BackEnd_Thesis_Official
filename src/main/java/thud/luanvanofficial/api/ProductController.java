package thud.luanvanofficial.api;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.repository.ProductRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/products", produces = "application/json")
@CrossOrigin(origins = "*")
public class ProductController {
    private ProductRepository repository;
    public ProductController(ProductRepository tacoRepo) {
        repository = tacoRepo;
    }
    @GetMapping
    public Iterable<Product> allProducts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Optional<Product> optproduct = repository.findById(id);
        if (optproduct.isPresent()) {
            return new ResponseEntity<>(optproduct.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
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

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Product patchProduct(@PathVariable Long id,
                            @RequestBody Product patch) {

        Product product = repository.findById(id).get();
        if (patch.getBrand() != null) {
            product.setBrand(patch.getBrand());
        }
        if (patch.getCategory() != null) {
            product.setCategory(patch.getCategory());
        }
        if (patch.getAmortization() != null) {
            product.setAmortization(patch.getAmortization());
        }
        if (patch.getDescription() != null) {
            product.setDescription(patch.getDescription());
        }
        if (patch.getName() != null) {
            product.setName(patch.getName());
        }
//        if (patch.getImage_url() != null) {
//            product.setImage_url(patch.getImage_url());
//        }
//        if (patch.getNew_price() != 0f) {
//            product.setImage_url(patch.getImage_url());
//        }
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
