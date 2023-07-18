package com.example.interview.dto;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long customerId;

    String firstName;
    String lastName;
    Integer age;
    Double spendingLimit;
    String mobileNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    List<Address> address;
}
