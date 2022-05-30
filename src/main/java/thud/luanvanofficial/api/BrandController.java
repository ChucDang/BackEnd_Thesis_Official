package thud.luanvanofficial.api;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.entity.Brand;
import thud.luanvanofficial.repository.BrandRepository;
import java.util.Optional;
@RestController
@RequestMapping(path="/brands", produces="application/json")
@CrossOrigin(origins="*")
public class BrandController {
    private BrandRepository repo;
    public BrandController(BrandRepository repo) {
        this.repo = repo;
    }

    @GetMapping()
    public Iterable<Brand> allBrand() {
        System.out.println("Lấy tất cả Brand");
        return repo.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Brand> tacoById(@PathVariable("id") int id) {
        Optional<Brand> optTaco = repo.findById(id);
        if (optTaco.isPresent()) {
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
//    Postman: http://localhost:8080/brands?id=10
//@GetMapping()
//public Brand oneBrand(@RequestParam int id) {
//    System.out.println("Lấy một brand");
//    Optional<Brand> opbrand = repo.findById(id);
//    return opbrand.get();
//}
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Brand postBrand(@RequestBody Brand brand) {
        return repo.save(brand);
    }

    @PutMapping
    public Brand putBrand(@RequestBody Brand brand) {
        System.out.println("Put thành công");
        return repo.save(brand);
    }

    @PatchMapping("/{id}")
    public Brand patchBrand(@PathVariable int id,
                                @RequestBody Brand patch) {

        Brand brand = repo.findById(id).get();
        if (patch.getCode() != null) {
            brand.setCode(patch.getCode());
        }
        return repo.save(brand);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBrand(@PathVariable("id") int id) {
        try {
            repo.deleteById(id);
            System.out.println("Xóa thành công");
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Xóa thất bại");
        }
    }
}
