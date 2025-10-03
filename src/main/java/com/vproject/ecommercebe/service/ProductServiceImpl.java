package com.vproject.ecommercebe.service;

import com.vproject.ecommercebe.payload.ProductResponse;
import com.vproject.ecommercebe.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponse getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        return null;
    }
}
