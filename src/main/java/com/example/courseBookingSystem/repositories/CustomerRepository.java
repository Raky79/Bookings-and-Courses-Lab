package com.example.courseBookingSystem.repositories;

import com.example.courseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String name);

}
