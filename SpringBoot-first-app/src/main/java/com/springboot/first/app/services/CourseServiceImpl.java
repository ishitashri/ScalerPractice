package com.springboot.first.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.first.app.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;

	public CourseServiceImpl() {
		list = new ArrayList<Course>();
		list.add(new Course(1, "Java", "This book contains Java content"));
		list.add(new Course(2, "Kubenetes", "This book contains Kubernetes content"));
		list.add(new Course(3, "Docker", "This book contains Docker content"));
	}

	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(int courseId) {
		Course c = null;
		for (Course course : list) {
			if (course.getId() == courseId) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course modifyCourse(Course newCourse, int courseId) {
		for (Course course : list) {
			if (course.getId() == courseId) {
				course.setDescription(newCourse.getDescription());
				course.setName(newCourse.getName());
			}
		}
		return newCourse;
	}

	@Override
	public List<Course> deleteCourse(int courseId) {
		for (Course course : list) {
			if (course.getId() == courseId) {
				list.remove(course);
			}
		}
		return list;
	}
}
