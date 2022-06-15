package thud.luanvanofficial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.Catergory;
import thud.luanvanofficial.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }


    public List<Product> findAllByCatergory(Optional<Catergory> catergory) {
        return productRepository.findAllByCatergoryCode(catergory);
    }
}
