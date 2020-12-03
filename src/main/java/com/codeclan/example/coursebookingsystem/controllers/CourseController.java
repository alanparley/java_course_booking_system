package com.codeclan.example.coursebookingsystem.controllers;


import com.codeclan.example.coursebookingsystem.models.Course;
import com.codeclan.example.coursebookingsystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

        @Autowired
        CourseRepository courseRepository;

        @GetMapping(value="/courses")
        public ResponseEntity<List<Course>> getAllCourses(@RequestParam(name="rating", required = false) Integer rating){

            if(rating != null){
                return new ResponseEntity<>(courseRepository.findCoursesByRating(rating), HttpStatus.OK);
            }
            return new ResponseEntity<List<Course>>(courseRepository.findAll(), HttpStatus.OK);
        }
    }
