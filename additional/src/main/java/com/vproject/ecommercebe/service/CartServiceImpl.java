package com.vproject.ecommercebe.service;

import com.vproject.ecommercebe.entity.CartItemEntity;
import com.vproject.ecommercebe.payload.CartItemRequest;
import com.vproject.ecommercebe.payload.ProductResponse;
import com.vproject.ecommercebe.payload.UserResponse;
import com.vproject.ecommercebe.repository.CartItemRepository;
import com.vproject.ecommercebe.repository.ProductRepository;
import com.vproject.ecommercebe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addToCart(String userId, CartItemRequest request) {
        // Look for product
//        ProductResponse productResponse = productServiceClient.getProductDetails(request.getProductId());
//        if (productResponse == null || productResponse.getStockQuantity() < request.getQuantity())
//            return false;
//
//        UserResponse userResponse = userServiceClient.getUserDetails(userId);
//        if (userResponse == null)
//            return false;
//
//        CartItemEntity existingCartItem = cartItemRepository.findByUserIdAndProductId(userId, request.getProductId());
//        if (existingCartItem != null) {
//            // Update the quantity
//            existingCartItem.setQuantity(existingCartItem.getQuantity() + request.getQuantity());
//            existingCartItem.setPrice(BigDecimal.valueOf(1000.00));
//            cartItemRepository.save(existingCartItem);
//        } else {
//            // Create new cart item
//            CartItemEntity cartItem = new CartItemEntity();
//            cartItem.setUserId(userId);
//            cartItem.setProductId(request.getProductId());
//            cartItem.setQuantity(request.getQuantity());
//            cartItem.setPrice(BigDecimal.valueOf(1000.00));
//            cartItemRepository.save(cartItem);
//        }
        return true;
    }

    @Override
    public boolean addToCartFallBack(String userId,
                                     CartItemRequest request,
                                     Exception exception) {
        exception.printStackTrace();
        return false;
    }

    @Override
    public boolean deleteItemFromCart(String userId, String productId) {
//        CartItemEntity cartItem = cartItemRepository.findByUserIdAndProductId(userId, productId);
//
//        if (cartItem != null){
//            cartItemRepository.delete(cartItem);
//            return true;
//        }
        return false;
    }

    @Override
    public List<CartItemEntity> getCart(String userId) {
        return null;
    }

    @Override
    public void clearCart(String userId) {
//        cartItemRepository.deleteByUserId(userId);
    }
}
