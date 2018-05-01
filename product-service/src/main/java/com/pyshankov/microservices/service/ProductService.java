package com.pyshankov.microservices.service;

import com.pyshankov.microservices.domain.Product;
import com.pyshankov.microservices.domain.ProductEventType;
import com.pyshankov.microservices.hazelcast.cache.HazelcastClientTemplate;
import com.pyshankov.microservices.repository.ProductRepository;
import com.pyshankov.microservices.domain.ProductEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
  
    @Autowired
    private AmqpProducerService amqpProducerService;

    public void persist(Product product) {
        productRepository.save(product);
        amqpProducerService.produceMsg(new ProductEvent(product.getId(),null, ProductEventType.CREATE_PRODUCT));
    }

    public void deleteProduct(String id) {
        productRepository.delete(id);
        amqpProducerService.produceMsg(new ProductEvent(id,null, ProductEventType.DELETE_PRODUCT));
    }

    public Product getProduct(String id) {
        amqpProducerService.produceMsg(new ProductEvent(id,null, ProductEventType.VIEW_PRODUCT));
        return productRepository.findOne(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
