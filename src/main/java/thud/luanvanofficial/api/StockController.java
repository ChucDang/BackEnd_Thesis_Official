package thud.luanvanofficial.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import thud.luanvanofficial.entity.Stock;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.service.StockService;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/stock")
@CrossOrigin(origins = "*")
public class StockController {
    private StockService stockService;
    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    @GetMapping
    @RolesAllowed({"ROLE_STAFF","ROLE_ADMIN"})
    public ResponseEntity<?> getAllProducts(@AuthenticationPrincipal User user){
        return stockService.getAllProducts();
    }
    @PostMapping("/{idStore}")
    @RolesAllowed({"ROLE_STAFF","ROLE_ADMIN"})
    public ResponseEntity<?> addStock(@PathVariable Long idStore, @RequestBody Stock stock , @AuthenticationPrincipal User user){
        return stockService.addStock(idStore,stock);
    }
    @GetMapping("/getAllStore")
    public ResponseEntity<?> getAllStore(){
        return stockService.getAllStores();
    }

}
