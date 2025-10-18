package com.vproject.product.controllers;

import com.vproject.product.dto.ProductRequest;
import com.vproject.product.dto.ProductResponse;
import com.vproject.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        log.info("[REQUEST] Create product name='{}' category='{}'", productRequest.getName(), productRequest.getCategory());
        ProductResponse created = productService.createProduct(productRequest);
        log.info("[RESPONSE] Product created id={}", created.getId());
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts() {
        log.info("[REQUEST] Get all active products");
        List<ProductResponse> products = productService.getAllProducts();
        log.info("[RESPONSE] Returning {} products", products.size());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
        log.info("[REQUEST] Get product by id={}", id);
        return productService.getProductById(id)
                .map(p -> {
                    log.debug("[RESPONSE] Found product id={} name='{}'", p.getId(), p.getName());
                    return ResponseEntity.ok(p);
                })
                .orElseGet(() -> {
                    log.warn("[RESPONSE] Product not found id={}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        log.info("[REQUEST] Update product id={}", id);
        return productService.updateProduct(id, productRequest)
                .map(p -> {
                    log.info("[RESPONSE] Product updated id={} name='{}'", p.getId(), p.getName());
                    return ResponseEntity.ok(p);
                })
                .orElseGet(() -> {
                    log.warn("[RESPONSE] Update failed - product not found id={}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        log.info("[REQUEST] Delete product id={}", id);
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            log.info("[RESPONSE] Product soft-deleted id={}", id);
            return ResponseEntity.noContent().build();
        }
        log.warn("[RESPONSE] Delete failed - product not found id={}", id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> searchProducts(@RequestParam String keyword) {
        log.info("[REQUEST] Search products keyword='{}'", keyword);
        List<ProductResponse> results = productService.searchProducts(keyword);
        log.info("[RESPONSE] Search keyword='{}' returned {} products", keyword, results.size());
        return ResponseEntity.ok(results);
    }
}
