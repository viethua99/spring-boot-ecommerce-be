package com.vproject.ecommercebe.service;

import com.vproject.ecommercebe.entity.CartItemEntity;
import com.vproject.ecommercebe.payload.CartItemRequest;

import java.util.List;

public interface CartService {

    boolean addToCart(String userId, CartItemRequest request);

    boolean addToCartFallBack(String userId,
                              CartItemRequest request,
                              Exception exception);

    boolean deleteItemFromCart(String userId, String productId);

    List<CartItemEntity> getCart(String userId);

    void clearCart(String userId);
}
