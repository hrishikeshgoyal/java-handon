package com.quest.springbootelasticsearch.repository;

import com.quest.springbootelasticsearch.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, Integer> {
}
