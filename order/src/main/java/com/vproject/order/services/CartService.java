package com.vproject.order.services;

import com.vproject.order.dto.CartItemRequest;
import com.vproject.order.entities.CartItemEntity;

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

