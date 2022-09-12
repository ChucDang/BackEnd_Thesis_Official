package thud.luanvanofficial.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.service.CategoryAndBrandService;

@RestController
@RequestMapping(path = "/categories")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class CategoryController {
    private CategoryAndBrandService categoryAndBrandService;
    @Autowired
    public CategoryController(CategoryAndBrandService categoryAndBrandService) {
        this.categoryAndBrandService = categoryAndBrandService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getAllBrandsScreensCpusStorages(@PathVariable String code) {
        return categoryAndBrandService.getAllBrandsScreensCpusStorages(code);
    }
    @GetMapping("/checkExist/{code}")
    public ResponseEntity<?> getBrandsIfExist(@PathVariable String code){

        return categoryAndBrandService.getBrandsIfExist(code);
    }
    @PostMapping("/addNewCategory")
    public ResponseEntity<?> addNewCategory(@RequestPart String category, @RequestPart String brands){

        return categoryAndBrandService.addNewCategory(category, brands);
    }
    @GetMapping("/getAllCategory")
    public ResponseEntity<?> getAllCategory(){
        return categoryAndBrandService.getAllCategory();
    }
}
