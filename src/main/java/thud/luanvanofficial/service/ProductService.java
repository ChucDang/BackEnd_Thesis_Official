package thud.luanvanofficial.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import thud.luanvanofficial.dto.ProductDTO;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.Category;
import thud.luanvanofficial.entity.Image;
import thud.luanvanofficial.repository.ProductRepository;
import thud.luanvanofficial.util.ConsoleColors;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.Optional;

@Service
public class ProductService {
    private ServletContext servletContext;
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ServletContext servletContext, ProductRepository productRepository) {
        this.servletContext = servletContext;
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public Page<Product> findAllByCategory(Optional<Category> category, Pageable pageable) {
        return productRepository.findAllByCategoryCode(category, pageable);
    }

    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    public void updateProduct(Product product) {
        try {
            productRepository.save(product);
        } catch (Exception e) {
            System.out.println( ConsoleColors.GREEN + "file 1111 "+ e.toString() +ConsoleColors.RESET);
            throw new Error(e.toString());
        }
       
    }

    public ResponseEntity<?> createProduct(Product product) {
        String path = servletContext.getRealPath("/");
        System.out.println("path "+ path);
        try{
//            String filePath = path + "/" + product.getPhoto();
        }catch (Exception e){

        }
        return ResponseEntity.ok("Nothing");
    }
    public Product getJson(String _txtProduct){
        
        ProductDTO newProductDTO = new ProductDTO();
        Product newProduct = new Product();
        try{
            ObjectMapper objectMapper = new ObjectMapper();
           
            newProductDTO = objectMapper.readValue(_txtProduct, ProductDTO.class);
            ModelMapper modelMapper = new ModelMapper();
            newProduct = modelMapper.map(newProductDTO, Product.class);
        } catch (JsonProcessingException e) {
            System.out.println("Lỗi");
            throw new RuntimeException(e);
        }

        return newProduct;
    }

    
}
