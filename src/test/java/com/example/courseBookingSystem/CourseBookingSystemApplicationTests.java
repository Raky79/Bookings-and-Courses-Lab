package com.example.courseBookingSystem;

import com.example.courseBookingSystem.models.Booking;
import com.example.courseBookingSystem.models.Course;
import com.example.courseBookingSystem.models.Customer;
import com.example.courseBookingSystem.repositories.BookingRepository;
import com.example.courseBookingSystem.repositories.CourseRepository;
import com.example.courseBookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCustomerByCourses() {
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseNameIgnoreCase("Software Development");
		assertEquals(1, foundCustomers.size());
	}

	@Test
	public void canFindCourseByRating() {
		List <Course> foundCourse = courseRepository.findByRating(5);
		assertEquals(2, foundCourse.size());
	}

	@Test
	public void canFindBookingByDate() {
		List <Booking> foundBooking = bookingRepository.findByDate("26/07/2023");
		assertEquals(1, foundBooking.size());
	}

	@Test
	public void canFindCoursesByCustomerName() {
		List <Course> foundCourse = courseRepository.findByBookingsCustomerNameIgnoreCase("Jane");
		assertEquals(1, foundCourse.size());
	}


}
