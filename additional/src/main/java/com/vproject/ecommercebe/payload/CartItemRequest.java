package com.vproject.ecommercebe.payload;

import lombok.Data;

@Data
public class CartItemRequest {
    private String productId;
    private Integer quantity;
}

