package com.vproject.order.services;

import com.vproject.order.dto.OrderResponse;
import java.util.Optional;

public interface OrderService {
     Optional<OrderResponse> createOrder(String userId);
}
