package com.pkware.SpringRestApplication.services;

import java.util.List;

import com.pkware.SpringRestApplication.entities.Course;

public interface CourseService {

	public List<Course> getCourses();

	public Course getCourse(long courseId);

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(long parseLong);
}
