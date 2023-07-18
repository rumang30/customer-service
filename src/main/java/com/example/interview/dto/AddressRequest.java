package com.example.interview.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {
    String type;
    String address1;
    Integer address2;
    String city;

    String zipCode;
    String state;
}
