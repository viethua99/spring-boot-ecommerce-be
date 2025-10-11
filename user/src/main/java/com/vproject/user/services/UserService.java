package com.vproject.user.services;

import com.vproject.user.dto.UserRequest;
import com.vproject.user.dto.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserResponse> fetchAllUsers();
    Optional<UserResponse> fetchUser(String id);
    void addUser(UserRequest userRequest);
    boolean updateUser(String id, UserRequest updatedUserRequest);
}
