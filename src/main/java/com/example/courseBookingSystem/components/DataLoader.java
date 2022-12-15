package com.example.courseBookingSystem.components;

import com.example.courseBookingSystem.models.Booking;
import com.example.courseBookingSystem.models.Course;
import com.example.courseBookingSystem.models.Customer;
import com.example.courseBookingSystem.repositories.BookingRepository;
import com.example.courseBookingSystem.repositories.CourseRepository;
import com.example.courseBookingSystem.repositories.CustomerRepository;
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


    public void run(ApplicationArguments args) {

        Customer customer1 = new Customer("Pete", "Edinburgh", 25);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Jane", "Edinburgh", 27);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Laura", "Glasgow", 24);
        customerRepository.save(customer3);

        Course course1 = new Course("Glasgow", "Software Development", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Edinburgh", "Data Analysis", 4);
        courseRepository.save(course2);

        Course course3 = new Course("Edinburgh", "Web Dev Essentials", 5);
        courseRepository.save(course3);

        Booking booking1 = new Booking("27/08/2023", customer1, course2);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("26/07/2023", customer2, course3);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("02/03/2023", customer3, course1);
        bookingRepository.save(booking3);

    }
}
