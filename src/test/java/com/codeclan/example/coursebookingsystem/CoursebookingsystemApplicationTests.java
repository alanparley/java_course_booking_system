package com.codeclan.example.coursebookingsystem;

import com.codeclan.example.coursebookingsystem.models.Booking;
import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.repositories.BookingRepository;
import com.codeclan.example.coursebookingsystem.repositories.CourseRepository;
import com.codeclan.example.coursebookingsystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
class CoursebookingsystemApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetCoursesByRating() {
		List<Course> foundCourses = courseRepository.findCoursesByRating(1);
		assertEquals(1, foundCourses.size());
	}

	@Test
	public void canGetCustomersByCourseName() {
		List<Customer> foundCustomers = customerRepository.findCustomersByBookingsCourseName("Woodworking");
		assertEquals(2, foundCustomers.size());
	}

	@Test
	public void canGetCoursesByCustomerName(){
		List<Course> foundCourses = courseRepository.findCoursesByBookingsCustomerName("Ann");
		assertEquals(1, foundCourses.size());
	}

	@Test
	public void canGetBookingsByDate(){
		List<Booking> foundBookings = bookingRepository.findBookingsByDate("24-12-20");
		assertEquals(2, foundBookings.size());
	}
}
