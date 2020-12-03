package com.codeclan.example.coursebookingsystem.controllers;


import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.models.Customer;
import com.codeclan.example.coursebookingsystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

        @Autowired
        CourseRepository courseRepository;

        @GetMapping(value="/courses")
        public ResponseEntity<List<Course>> getAllCourses(@RequestParam(name="rating", required = false) Integer rating,
                                                          @RequestParam(name="name", required = false)String name){

            if(rating != null){
                return new ResponseEntity<>(courseRepository.findCoursesByRating(rating), HttpStatus.OK);
            }

            if (name != null){
                return new ResponseEntity<>(courseRepository.findCoursesByBookingsCustomerNameIgnoreCase(name), HttpStatus.OK);
            }

            return new ResponseEntity<List<Course>>(courseRepository.findAll(), HttpStatus.OK);
        }


    @GetMapping(value = "/courses/{id}")
    public ResponseEntity getCourse(@PathVariable Long id){
        return new ResponseEntity(courseRepository.findById(id), HttpStatus.OK);
    }

        @PostMapping(value="/courses")
        public ResponseEntity<Course> postCourse(@RequestBody Course course){
            Course newCourse = courseRepository.save(course);
            return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
        }
    }
