package com.example.interview.repository;

import com.example.interview.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByFirstNameAndAddressCityAndAddressZipCode(String firstName, String city, String zipCode);

    List<Customer> findByFirstNameAndAddressCity(@Nullable String firstName, @Nullable String city);

    List<Customer> findByFirstNameAndAddressZipCode(@Nullable String firstName, @Nullable String zipCode);

    List<Customer> findByAddressCityAndAddressZipCode(@Nullable String city, @Nullable String zipCode);

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByAddressCity(String city);

    List<Customer> findByAddressZipCode(String zipCode);



}
