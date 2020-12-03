package com.codeclan.example.coursebookingsystem.controllers;


import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(name="course-name", required = false) String courseName, @RequestParam (name = "town", required = false) String town){

        if (town !=null && courseName != null){
            return new ResponseEntity<>(customerRepository.findCustomersByTownAndBookingsCourseName(town, courseName), HttpStatus.OK);

        }

        if(courseName != null){
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseName(courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping(value ="/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable (value="id") Long id, @RequestBody Customer customer){
        customer.setName(customer.getName());
        customer.setAge(customer.getAge());
        customer.setTown(customer.getTown());
        final Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }


}
