package com.codeclan.example.coursebookingsystem.repositories;

import com.codeclan.example.coursebookingsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomersByBookingsCourseNameIgnoreCase(String courseName);

    List<Customer> findCustomersByTownAndBookingsCourseNameIgnoreCase(String town, String courseName);
}


//Get all customers in a given town for a given course