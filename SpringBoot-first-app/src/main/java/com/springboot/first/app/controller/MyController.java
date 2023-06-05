package com.springboot.first.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springboot.first.app.entities.Course;
import com.springboot.first.app.services.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String test() {
		return "Welcome to SpringBoot Rest Application";
	}

	// Get the list of courses
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseService.getCourses();
	}

	// Get one course at a time
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable int courseId) {
		return this.courseService.getCourse(courseId);
	}

	// add course
	@PostMapping(path = "/courses", consumes = "application/JSON")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}

	// Modify Request
	@PutMapping("/courses/{courseId}")
	public Course modifyCourse(@RequestBody Course course, @PathVariable int courseId) {
		return this.courseService.modifyCourse(course, courseId);
	}

	// Delete Course
	@DeleteMapping("/courses/{courseId}")
	public List<Course> deleteCourse(@PathVariable int courseId) {
		return this.courseService.deleteCourse(courseId);
	}
}
