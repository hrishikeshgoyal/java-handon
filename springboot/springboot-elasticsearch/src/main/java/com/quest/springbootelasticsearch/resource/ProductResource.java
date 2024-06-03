package com.quest.springbootelasticsearch.resource;

import com.quest.springbootelasticsearch.entity.Product;
import com.quest.springbootelasticsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis")
public class ProductResource {
    @Autowired
    private ProductService productService;
    @GetMapping("/findAll")
    Iterable<Product> findAll() {
        return productService.getProducts();
    }

    @PostMapping("/products")
    public Product insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }
}
