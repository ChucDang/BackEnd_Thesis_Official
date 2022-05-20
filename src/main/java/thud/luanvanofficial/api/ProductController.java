package thud.luanvanofficial.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.entity.Cart;
import thud.luanvanofficial.entity.Catergory;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.repository.ProductRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/products", produces = "application/json")
@CrossOrigin(origins = "*")
public class ProductController {
    private ProductRepository repository;
    @Autowired
    public ProductController(ProductRepository tacoRepo) {
        repository = tacoRepo;
    }
    @GetMapping(produces = "application/json")
    public Iterable<Product> allProducts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Product tacoById(@PathVariable("id") Long id) {
        Optional<Product> optTaco = repository.findById(id);
        if (optTaco.isPresent()) {
            return optTaco.get();
        }
        return null;
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Product postTaco(@RequestBody Product taco) {
        return repository.save(taco);
    }
}
