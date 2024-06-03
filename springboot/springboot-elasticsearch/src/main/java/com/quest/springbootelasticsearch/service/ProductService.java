package com.quest.springbootelasticsearch.service;

import com.quest.springbootelasticsearch.entity.Product;
import com.quest.springbootelasticsearch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product insertProduct(Product product) {

    }
}
