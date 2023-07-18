package com.example.interview.controller;

import com.example.interview.dto.Customer;
import com.example.interview.dto.GetCustomerRequest;
import com.example.interview.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/customer-service/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public static final Logger logger = Logger.getLogger(CustomerController.class.getName());


    @PostMapping
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
        logger.info("Create customer request received : " + customer.toString());
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public ResponseEntity<Object> getCustomer(@RequestParam(required = false) String firstName,
                                              @RequestParam(required = false) String city,
                                              @RequestParam(required = false) String zipCode){
        GetCustomerRequest getCustomerRequest = GetCustomerRequest.builder().city(Optional.ofNullable(city))
                .firstName(Optional.ofNullable(firstName))
                .zipCode(Optional.ofNullable(zipCode)).build();
        logger.info("Get customer request received : " + getCustomerRequest.toString());
        return customerService.getCustomer(getCustomerRequest);
    }

}
