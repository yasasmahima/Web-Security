package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.customer.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByAge(int age);
    List<Customer> findByName(String name);
    List<Customer>findByContactNo(int contactNo);
}