package ru.gb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.model.Product;
import ru.gb.repository.ProductRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public Product save(Product product){
        if (Objects.isNull(product.getId())){
            return productRepository.save(product);
        } else {
            Product updatedProduct = productRepository.findById(product.getId()).orElseThrow();
            updatedProduct.setTitle(product.getTitle());
            updatedProduct.setCost(product.getCost());
            return productRepository.save(updatedProduct);
        }
    }


    public List<Product> getAll(Double minCost, Double maxCost) {
        return productRepository.findAllByCostBetween(minCost, maxCost);
    }
}
