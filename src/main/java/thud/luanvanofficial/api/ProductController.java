package thud.luanvanofficial.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import thud.luanvanofficial.dto.MessageResponse;
import thud.luanvanofficial.dto.ProductResponseListDTO;
import thud.luanvanofficial.entity.Image;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.Category;
import thud.luanvanofficial.repository.CategoryRepository;
import thud.luanvanofficial.service.ImageService;
import thud.luanvanofficial.service.ProductService;


import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/products")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class ProductController {

    private ProductService productService;
    private ImageService imageService;

    private CategoryRepository categoryRepository;

    @Autowired
    public ProductController(ProductService productService, ImageService imageService, CategoryRepository categoryRepository) {
        this.productService = productService;
        this.imageService = imageService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/category/{code}/{page}/{size}")
    public ResponseEntity<?> getProductByCategoryCode(@PathVariable(name = "code") String code, @PathVariable(name = "page") int page, @PathVariable(name = "size") int size) {
        Optional<Category> category = categoryRepository.findByCode(code);
        Pageable _page = PageRequest.of(page, size);
        Page<Product> result = productService.findAllByCategory(category, _page);
        List<Product>  products = result.getContent();
        int total = result.getTotalPages();
        return ResponseEntity.ok(new ProductResponseListDTO(products, total));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Optional<Product> optproduct = productService.findById(id);
        if(optproduct.isPresent()) return ResponseEntity.ok(optproduct.get());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Product không tồn tại"));


    }
    @GetMapping("/allProducts")
    public ResponseEntity<?> getAllProducts(){
        return productService.getAllProducts();
    }
    @PostMapping(value = "/createOne", consumes =  { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<?> createOrUpdateProduct(@RequestPart("file")  MultipartFile file, @RequestPart("product") String _txtProduct){
         Product newProduct = productService.getJson(_txtProduct);
       
         
        String message = "";
        
        try {
            
            if(newProduct.getImage() != null){

                String idImage = newProduct.getImage().getId();
                
                Image storedImage = imageService.store(file);
                Image image = imageService.getById(storedImage.getId());
                newProduct.setImage(image);
                productService.updateProduct(newProduct);
                imageService.deleteById(idImage);
                
            }else{

                Image storedImage = imageService.store(file);
                Image image = imageService.getById(storedImage.getId());
                newProduct.setImage(image);
                productService.updateProduct(newProduct);
            }
           
          
            message = "Thêm product thành công !";
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
        } catch (Exception e) {
            message = "Không thể thêm Product này ";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
        }

    }

}
