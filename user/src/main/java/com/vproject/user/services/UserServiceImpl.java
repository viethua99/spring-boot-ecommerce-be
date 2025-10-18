package com.vproject.user.services;

import com.vproject.user.dto.AddressDto;
import com.vproject.user.dto.UserRequest;
import com.vproject.user.dto.UserResponse;
import com.vproject.user.entities.AddressEntity;
import com.vproject.user.entities.UserEntity;
import com.vproject.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponse> fetchAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserResponse> fetchUser(String id) {
        return userRepository.findById(id)
                .map(this::mapToUserResponse);
    }

    @Override
    public void addUser(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        updateUserFromRequest(userEntity, userRequest);
        userRepository.save(userEntity);
    }

    @Override
    public boolean updateUser(String id, UserRequest updatedUserRequest) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    updateUserFromRequest(existingUser, updatedUserRequest);
                    userRepository.save(existingUser);
                    return true;
                }).orElse(false);
    }

    private void updateUserFromRequest(UserEntity user, UserRequest userRequest) {
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        if (userRequest.getAddressDto() != null) {
            AddressEntity address = new AddressEntity();
            address.setStreet(userRequest.getAddressDto().getStreet());
            address.setState(userRequest.getAddressDto().getState());
            address.setZipcode(userRequest.getAddressDto().getZipcode());
            address.setCity(userRequest.getAddressDto().getCity());
            address.setCountry(userRequest.getAddressDto().getCountry());
            user.setAddress(address);
        }
    }

    private UserResponse mapToUserResponse(UserEntity userEntity) {
        UserResponse response = new UserResponse();
        response.setId(String.valueOf(userEntity.getId()));
        response.setFirstName(userEntity.getFirstName());
        response.setLastName(userEntity.getLastName());
        response.setEmail(userEntity.getEmail());
        response.setPhone(userEntity.getPhone());
        response.setUserRole(userEntity.getUserRole());

        if (userEntity.getAddress() != null) {
            AddressDto addressDTO = new AddressDto();
            addressDTO.setStreet(userEntity.getAddress().getStreet());
            addressDTO.setCity(userEntity.getAddress().getCity());
            addressDTO.setState(userEntity.getAddress().getState());
            addressDTO.setCountry(userEntity.getAddress().getCountry());
            addressDTO.setZipcode(userEntity.getAddress().getZipcode());
            response.setAddressDto(addressDTO);
        }
        return response;
    }
}
