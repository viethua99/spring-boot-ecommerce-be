package com.vproject.ecommercebe.service;

import com.vproject.ecommercebe.payload.ProductRequest;
import com.vproject.ecommercebe.payload.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductResponse createProduct(ProductRequest productRequest);

    Optional<ProductResponse> updateProduct(Long id, ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

    boolean deleteProduct(Long id);

    List<ProductResponse> searchProducts(String keyword);

    Optional<ProductResponse> getProductById(String id);
}
