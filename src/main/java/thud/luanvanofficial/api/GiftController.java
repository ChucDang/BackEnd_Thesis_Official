package thud.luanvanofficial.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.dto.MessageResponse;
import thud.luanvanofficial.entity.Gift;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.repository.GiftRepository;
import thud.luanvanofficial.repository.ProductRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@RestController
@RequestMapping(path = "/gifts", produces = "application/json")
@CrossOrigin(origins = "*")
public class GiftController {
    private GiftRepository giftRepository;
    private ProductRepository productRepository;
    @Autowired
    public GiftController(GiftRepository giftRepository, ProductRepository productRepository) {
        this.giftRepository = giftRepository;
        this.productRepository = productRepository;
    }
    @GetMapping()
    public ResponseEntity<?> getAllGifts(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(giftRepository.findAll()) ;
    }
    @PostMapping("/createAGift")
    @RolesAllowed({"ROLE_STAFF", "ROLE_ADMIN"})
    public ResponseEntity<?> createAGift(@RequestBody Gift gift, @AuthenticationPrincipal User user){
       

        if(gift.getList_gifts().length() > 0){
            Gift savedGift = giftRepository.save(gift);
      

            return ResponseEntity.ok(savedGift);
        }
        return ResponseEntity.ok(new MessageResponse("Thêm Gift thất bại. Vui lòng thử lại sau."));

    }
    @DeleteMapping("/deleteAGift/{id}")
    @RolesAllowed({"ROLE_STAFF", "ROLE_ADMIN"})
    public ResponseEntity<?> deleteAGift(@PathVariable String id, @AuthenticationPrincipal User user){
        Optional<Gift> existGift = giftRepository.findById(id);
        if (existGift.isPresent()) {
            ListIterator<Product> listIterator;
            //Nếu product có Gift này thì phải xóa quan hệ với Gift
            List<Product> listOldProducts = giftRepository.findProductsByGift(existGift.get());
            listIterator = listOldProducts.listIterator();
            while (listIterator.hasNext())
                listIterator.next().setGift(null);
            giftRepository.delete(existGift.get());
            return ResponseEntity.ok(new MessageResponse("Xóa Gift thành công"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Gift không tồn tại"));
        }
    }

    @PostMapping("/addProductsInGift/{code}")
    @RolesAllowed({"ROLE_STAFF", "ROLE_ADMIN"})
    public ResponseEntity<?> addProductsInGift(@PathVariable String code, @RequestBody List<Product> products, @AuthenticationPrincipal User user) {
        Optional<Gift> existGift = giftRepository.findById(code);
        ListIterator<Product> listIterator;
        //Nếu product có sale này thì phải xóa quan hệ với sale, sau đó mới thêm lại.
        List<Product> listOldProducts = giftRepository.findProductsByGift(existGift.get());
        listIterator = listOldProducts.listIterator();
        while (listIterator.hasNext())
            listIterator.next().setSale(null);


        //Thêm sale vào product
        if (existGift.isPresent()) {

            listIterator = products.listIterator();
            while (listIterator.hasNext())
                listIterator.next().setGift(existGift.get());

            productRepository.saveAll(products);


            return ResponseEntity.ok( new MessageResponse("Thêm danh sách thành công"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Thêm product không thành công"));

    }

    @GetMapping("/getProductsByGift/{code}")
    @RolesAllowed({"ROLE_STAFF", "ROLE_ADMIN"})
    public ResponseEntity<?> getProductsByGift(@PathVariable String code){
        Optional<Gift> existGift = giftRepository.findById(code);
        List<Product> products = giftRepository.findProductsByGift(existGift.get());
        return ResponseEntity.ok(products);
    }
}
