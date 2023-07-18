package com.example.interview.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Getter
@Setter
@ToString
@Builder
public class GetCustomerRequest {

    Optional<String> firstName = Optional.empty();
    Optional<String> city= Optional.empty();
    Optional<String> zipCode= Optional.empty();
}
