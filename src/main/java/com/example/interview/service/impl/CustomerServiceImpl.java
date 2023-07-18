package com.example.interview.service.impl;

import com.example.interview.dto.Customer;
import com.example.interview.dto.GetCustomerRequest;
import com.example.interview.repository.CustomerRepository;
import com.example.interview.service.CustomerService;
import com.example.interview.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CustomerServiceImpl implements CustomerService {

    PublishService publishService;
    CustomerRepository customerRepository;


    public static final Logger logger = Logger.getLogger(CustomerServiceImpl.class.getName());


    @Autowired
    CustomerServiceImpl(PublishService publishService, CustomerRepository customerRepository) {
        this.publishService = publishService;
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<Object> addCustomer(Customer customer) {
        try {
            this.customerRepository.save(customer);
            logger.info("Added customer object to database:" + customer.getCustomerId());
            this.publishService.publish(customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> getCustomer(GetCustomerRequest customer) {
        try {
            logger.info("Fetching customer object to database " + customer.toString());
            List<Customer> customers;
            if (customer.getFirstName().isEmpty() && customer.getCity().isEmpty() && customer.getZipCode().isEmpty())
                customers = customerRepository.findAll();

            else if (customer.getFirstName().isPresent() && customer.getCity().isPresent() && customer.getZipCode().isPresent())
                customers = customerRepository.findByFirstNameAndAddressCityAndAddressZipCode(customer.getFirstName().get(), customer.getCity().get(), customer.getZipCode().get());

                // If both firstName and city parameters are supplied
            else if (customer.getFirstName().isPresent() && customer.getCity().isPresent())
                customers = customerRepository.findByFirstNameAndAddressCity(customer.getFirstName().get(), customer.getCity().get());

                // If both firstName and zipCode parameters are supplied
            else if (customer.getFirstName().isPresent() && customer.getZipCode().isPresent())
                customers = customerRepository.findByFirstNameAndAddressZipCode(customer.getFirstName().get(), customer.getZipCode().get());

                // If both zipCode and city parameters are supplied
            else if (customer.getZipCode().isPresent() && customer.getCity().isPresent())
                customers = customerRepository.findByAddressCityAndAddressZipCode( customer.getCity().get(),customer.getZipCode().get());

                // Filter customers based on other parameters
            else if (customer.getFirstName().isPresent())
                customers = customerRepository.findByFirstName(customer.getFirstName().get());
            else if (customer.getCity().isPresent())
                customers = customerRepository.findByAddressCity(customer.getCity().get());
            else
                customers = customerRepository.findByAddressZipCode(customer.getZipCode().get());

            logger.info("Fetched customer object to database:" + customers.toString());
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
