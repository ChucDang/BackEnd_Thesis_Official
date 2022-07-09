package thud.luanvanofficial.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.dto.ProductResponseListDTO;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.Catergory;
import thud.luanvanofficial.repository.catalogRepo.CatergoryRepository;
import thud.luanvanofficial.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/products")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CatergoryRepository catergoryRepository;

    @GetMapping("/catergory/")
    public ResponseEntity<?> getProductByCatergoryCode(@RequestParam(name = "code") String code, @RequestParam( name = "page") int page, @RequestParam( name = "size") int size) {
        Optional<Catergory> catergory = catergoryRepository.findByCode(code);
        Pageable _page = PageRequest.of(page, size);
        Page<Product> result = productService.findAllByCatergory(catergory, _page);
        List<Product>  products = result.getContent();
        int total = result.getTotalPages();
        return ResponseEntity.ok(new ProductResponseListDTO(products, total));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Optional<Product> optproduct = productService.findById(id);
        return ResponseEntity.ok( optproduct);
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
