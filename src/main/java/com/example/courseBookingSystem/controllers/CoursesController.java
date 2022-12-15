package com.example.courseBookingSystem.controllers;


import com.example.courseBookingSystem.models.Course;
import com.example.courseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoursesController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "courses")
    public ResponseEntity<List<Course>> getAllCoursesOrFilteredCourses(@RequestParam(name = "rating", required = false) Integer rating,
                                                                       @RequestParam(name ="name", required = false) String name) {
        if(rating != null) {
            List <Course> courses = courseRepository.findByRating(rating);
            return new ResponseEntity<>(courses, HttpStatus.OK);
        }
        if(name != null) {
            List <Course> courses = courseRepository.findByBookingsCustomerNameIgnoreCase(name);
            return new ResponseEntity<>(courses, HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

}
