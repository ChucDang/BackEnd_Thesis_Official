package thud.luanvanofficial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import thud.luanvanofficial.entity.Product;
import thud.luanvanofficial.entity.Catergory;
import thud.luanvanofficial.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Optional<Product>  findById(Long id) {
        return productRepository.findById(id);
    }
    public Product findProductById(Long id){
        return productRepository.findProductById(id);
    }

    public Page<Product> findAllByCatergory(Optional<Catergory> catergory, Pageable pageable) {
        return productRepository.findAllByCatergoryCode(catergory, pageable);
    }
}
