package com.vproject.user.entities;

import lombok.Data;

@Data
public class AddressEntity {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;
}
