package com.example.interview.service.impl;

import com.example.interview.dto.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Question2ServiceImpl {

    public List<Customer> getCustomersOnlyInA(List<Customer> listA,List<Customer> listB){
        Set<Long> listAId = listA.stream().map(Customer::getCustomerId).collect(Collectors.toSet());
        Set<Long> listBId = listB.stream().map(Customer::getCustomerId).collect(Collectors.toSet());
        Set<Long> distinctAId = listAId.stream().filter(curr->!listBId.contains(curr)).collect(Collectors.toSet());
        return listA.stream().filter(curr->distinctAId.contains(curr.getCustomerId())).collect(Collectors.toList());
    }

    public List<Customer> getCustomersOnlyInB(List<Customer> listA,List<Customer> listB){
        Set<Long> listAId = listA.stream().map(Customer::getCustomerId).collect(Collectors.toSet());
        Set<Long> listBId = listB.stream().map(Customer::getCustomerId).collect(Collectors.toSet());
        Set<Long> distinctBId = listBId.stream().filter(curr->!listAId.contains(curr)).collect(Collectors.toSet());
        return listB.stream().filter(curr->distinctBId.contains(curr.getCustomerId())).collect(Collectors.toList());
    }

    public List<Customer> getCustomersInBoth(List<Customer> listA,List<Customer> listB){
        Set<Long> listAId = listA.stream().map(Customer::getCustomerId).collect(Collectors.toSet());
        Set<Long> listBId = listB.stream().map(Customer::getCustomerId).collect(Collectors.toSet());
        Set<Long> commonId = listBId.stream().filter(curr->listAId.contains(curr)).collect(Collectors.toSet());
        return listA.stream().filter(curr -> commonId.contains(curr.getCustomerId())).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<Customer> a = new ArrayList<>();
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setAge(12);
        a.add(customer);
        customer = new Customer();
        customer.setCustomerId(2L);
        customer.setAge(13);
        a.add(customer);
        customer = new Customer();
        customer.setCustomerId(3L);
        customer.setAge(14);
        a.add(customer);
        List<Customer> b = new ArrayList<>();
        customer = new Customer();
        customer.setCustomerId(4L);
        customer.setAge(12);
        b.add(customer);
        customer = new Customer();
        customer.setCustomerId(2L);
        customer.setAge(13);
        b.add(customer);
        customer = new Customer();
        customer.setCustomerId(3L);
        customer.setAge(14);
        b.add(customer);
        System.out.println(new Question2ServiceImpl().getCustomersInBoth(a,b));
    }
}
