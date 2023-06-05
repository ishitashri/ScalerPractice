package com.springboot.first.app.services;

import java.util.List;

import com.springboot.first.app.entities.Course;

public interface CourseService {

	public List<Course> getCourses();
	
	public Course getCourse(int courseId);
	
	public Course addCourse(Course course);

	public Course modifyCourse(Course course, int courseId);
	
	public List<Course> deleteCourse(int courseId);

}
