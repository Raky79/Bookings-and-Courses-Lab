package com.example.courseBookingSystem.controllers;

import com.example.courseBookingSystem.models.Customer;
import com.example.courseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomersController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomersOrFilteredCustomers(@RequestParam(name = "course", required = false) String name) {
        if(name != null) {
            List <Customer> customers = customerRepository.findByBookingsCourseNameIgnoreCase(name);
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
        return  new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }


}
