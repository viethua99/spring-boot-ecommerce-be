package com.vproject.ecommercebe.service;

import com.vproject.ecommercebe.payload.ProductResponse;

public interface ProductService {
    ProductResponse getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

}
