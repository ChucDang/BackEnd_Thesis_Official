package thud.luanvanofficial.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thud.luanvanofficial.repository.SaleRepository;

@RestController
@RequestMapping(path = "/sales", produces = "application/json")
@CrossOrigin(origins = "*")
public class SaleController {
    SaleRepository saleRepository;

    public SaleController(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

}
