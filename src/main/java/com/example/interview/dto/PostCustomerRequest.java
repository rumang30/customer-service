package com.example.interview.dto;

import java.util.List;

public class PostCustomerRequest {
    String customerId;

    String firstName;
    String lastName;
    Integer age;
    Double spendingLimit;
    String mobileNumber;

    List<Address> addressList;
}
