package com.example.interview.service;

import com.example.interview.dto.Customer;
import com.example.interview.dto.GetCustomerRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    ResponseEntity<Object> addCustomer(Customer customer);

    ResponseEntity<Object> getCustomer(GetCustomerRequest customer);

}
