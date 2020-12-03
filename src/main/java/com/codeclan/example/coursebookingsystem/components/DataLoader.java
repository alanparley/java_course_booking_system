package com.codeclan.example.coursebookingsystem.components;

import com.codeclan.example.coursebookingsystem.models.Booking;
import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.repositories.BookingRepository;
import com.codeclan.example.coursebookingsystem.repositories.CourseRepository;
import com.codeclan.example.coursebookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){
        Customer alan = new Customer("Alan", "Edinburgh", 43);
        customerRepository.save(alan);

        Customer andrew = new Customer("Andrew", "Edinburgh", 28);
        customerRepository.save(andrew);

        Customer ann = new Customer("Ann", "Edinburgh", 48);
        customerRepository.save(ann);

        Course woodwork = new Course ("Woodworking", "Edinburgh", 4 );
        courseRepository.save(woodwork);

        Course knitting = new Course ("Knitting", "Edinburgh", 1 );
        courseRepository.save(knitting);

        Booking booking1 = new Booking ("24-12-2020", alan, woodwork);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking ("24-12-2020", andrew, woodwork);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking ("10-01-2021", ann, knitting);
        bookingRepository.save(booking3);

    }
}
