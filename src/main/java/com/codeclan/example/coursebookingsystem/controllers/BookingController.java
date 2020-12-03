package com.codeclan.example.coursebookingsystem.controllers;

import com.codeclan.example.coursebookingsystem.models.Booking;
import com.codeclan.example.coursebookingsystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value="/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(@RequestParam(name="date", required = false)String date){

        if (date != null){
            return new ResponseEntity<>(bookingRepository.findBookingsByDate(date), HttpStatus.OK);
        }

        return new ResponseEntity<List<Booking>>(bookingRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping(value="/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking){
        Booking newBooking = bookingRepository.save(booking);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity getBooking(@PathVariable Long id){
        return new ResponseEntity(bookingRepository.findById(id), HttpStatus.OK);
    }
}
