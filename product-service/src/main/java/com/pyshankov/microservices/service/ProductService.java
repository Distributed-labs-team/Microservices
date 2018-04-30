package com.pyshankov.microservices.service;

import com.pyshankov.microservices.domain.Product;
import com.pyshankov.microservices.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void createProduct(String name, String description, BigDecimal price) {
        Product product = new Product(name, description, price);
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }

    public Product getProduct(Long id) {
        return productRepository.findOne(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


}
