package com.vproject.ecommercebe.service;

import com.vproject.ecommercebe.payload.UserRequest;
import com.vproject.ecommercebe.payload.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponse> fetchAllUsers();
    Optional<UserResponse> fetchUser(Long id);
    void addUser(UserRequest userRequest);
    boolean updateUser(Long id, UserRequest updatedUserRequest);
}
