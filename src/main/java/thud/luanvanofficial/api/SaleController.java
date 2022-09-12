package thud.luanvanofficial.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.dto.MessageResponse;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.Sale;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.repository.ProductRepository;
import thud.luanvanofficial.repository.SaleRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@RestController
@RequestMapping(path = "/sales", produces = "application/json")
@CrossOrigin(origins = "*")
public class SaleController {
    SaleRepository saleRepository;
    ProductRepository productRepository;

    @Autowired
    public SaleController(SaleRepository saleRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    @GetMapping()
    public ResponseEntity<?> getAllSales(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(saleRepository.findAll());
    }

    @PostMapping("/createSale")
    @RolesAllowed({"ROLE_STAFF", "ROLE_ADMIN"})
    public ResponseEntity<?> createSale(@RequestBody Sale sale, @AuthenticationPrincipal User user) {
        Optional<Sale> exist = saleRepository.findById(sale.getCode());
        if (exist.isEmpty()) {
            saleRepository.save(sale);
            return ResponseEntity.ok(saleRepository.findAll());
        }else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("GiftCode đã tồn tại"));
    }

    @DeleteMapping("/deleteSale/{id}")
    @RolesAllowed({"ROLE_STAFF", "ROLE_ADMIN"})
    public ResponseEntity<?> deleteSale(@PathVariable String id, @AuthenticationPrincipal User user) {
        Optional<Sale> existSale = saleRepository.findById(id);
        if (existSale.isPresent()) {
            ListIterator<Product> listIterator;
            //Nếu product có sale này thì phải xóa quan hệ với sale
            List<Product> listOldProducts = productRepository.findProductsBySale(existSale.get());
            listIterator = listOldProducts.listIterator();
            while (listIterator.hasNext())
                listIterator.next().setSale(null);
            saleRepository.delete(existSale.get());
            return ResponseEntity.ok(saleRepository.findAll());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Sale không tồn tại"));
        }
    }

    @PostMapping("/addProductsInSale/{id}")
    @RolesAllowed({"ROLE_STAFF", "ROLE_ADMIN"})
    public ResponseEntity<?> addProductsInSale(@PathVariable String id, @RequestBody List<Product> products, @AuthenticationPrincipal User user) {
        Optional<Sale> existSale = saleRepository.findById(id);
        ListIterator<Product> listIterator;
        //Nếu product có sale này thì phải xóa quan hệ với sale, sau đó mới thêm lại.
        List<Product> listOldProducts = productRepository.findProductsBySale(existSale.get());
        listIterator = listOldProducts.listIterator();
        while (listIterator.hasNext())
            listIterator.next().setSale(null);


        //Thêm sale vào product
        if (existSale.isPresent()) {

            listIterator = products.listIterator();
            while (listIterator.hasNext())
                listIterator.next().setSale(existSale.get());

            productRepository.saveAll(products);


            return ResponseEntity.ok( new MessageResponse("Thêm danh sách thành công"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Thêm product không thành công"));

    }
    @GetMapping("/getProductsBySale/{id}")
    @RolesAllowed({"ROLE_STAFF", "ROLE_ADMIN"})
    public ResponseEntity<?> getProductBySale(@PathVariable String id, @AuthenticationPrincipal User user){
        Optional<Sale> existSale = saleRepository.findById(id);
        if(existSale.isPresent()){
            List<Product> products = productRepository.findProductsBySale(existSale.get());
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Không lấy được danh sách sản phẩm"));
    }

}
