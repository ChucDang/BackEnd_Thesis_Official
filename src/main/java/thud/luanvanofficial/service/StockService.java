package thud.luanvanofficial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import thud.luanvanofficial.dto.MessageResponse;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.Stock;
import thud.luanvanofficial.entity.Stores;
import thud.luanvanofficial.repository.ProductRepository;
import thud.luanvanofficial.repository.StockRepository;
import thud.luanvanofficial.repository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    private ProductRepository productRepository;
    private StockRepository stockRepository;
    private StoreRepository storeRepository;
    @Autowired
    public StockService(ProductRepository productRepository, StockRepository stockRepository, StoreRepository storeRepository) {
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
        this.storeRepository = storeRepository;
    }

    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(stockRepository.getAllProducts());
    }

    public ResponseEntity<?> getAllStores(){
        List<Stores> stores = storeRepository.findAll();
        return ResponseEntity.ok(stores);
    }

    public ResponseEntity<?> addStock(Long idStore, Stock stock) {

        // Optional<Stock> productStock = stockRepository.getStockByProductIdAndPriceAndStores(stock.getId(), stock.getPrice(), idStore);
        // if(productStock.isPresent()){
        //     productStock.get().setAmount(productStock.get().getAmount()+ stock.getAmount());
        //     stockRepository.save(productStock.get());

        // }else {
        //     Stock newStock = new Stock();
        //     //stock.id chính là product.id
        //     Product product = productRepository.findProductById(stock.getId());

        //     Optional<Stores> chooseStore = storeRepository.findById(idStore);
        //     if(chooseStore.isPresent()){
        //         newStock.setProduct(product);
        //         newStock.setAmount(stock.getAmount());
        //         newStock.setPrice(stock.getPrice());
        //         newStock.setStores(chooseStore.get());
        //         newStock.setId(stock.getId());
        //     }else {
        //         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Kho không tồn tại"));
        //     }

        //         stockRepository.save(newStock);
        //         product.setAmount(product.getAmount()+stock.getAmount());
        //         productRepository.save(product);



        // }
            Stock newStock = new Stock();
            //stock.id chính là product.id
            Product product = productRepository.findProductById(stock.getId());

            Optional<Stores> chooseStore = storeRepository.findById(idStore);
            if(chooseStore.isPresent()){
                newStock.setProduct(product);
                newStock.setAmount(stock.getAmount());
                newStock.setPrice(stock.getPrice());
                newStock.setStores(chooseStore.get());
              
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Kho không tồn tại"));
            }

                stockRepository.save(newStock);
                product.setAmount(product.getAmount()+stock.getAmount());
                productRepository.save(product);



        // }

        return ResponseEntity.ok(stockRepository.findAll());
    }
}
