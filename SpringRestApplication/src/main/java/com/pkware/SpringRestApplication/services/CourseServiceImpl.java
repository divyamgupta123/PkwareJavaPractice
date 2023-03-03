package com.pkware.SpringRestApplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkware.SpringRestApplication.dao.CourseDao;
import com.pkware.SpringRestApplication.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

	List<Course> list;

	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(1, "Java", "Java programming"));
//		list.add(new Course(2, "Python", "Python 3.9"));
	}

	@Override
	public List<Course> getCourses() {
		
		//return list;
		return courseDao.findAll();
		
	}

	@Override
	public Course getCourse(long courseId) {
//		
//		Course cr = null;
//		for (Course course : list) {
//			if (course.getId() == courseId) {
//				cr = course;
//				break;
//			}
//		}
		//return cr;
		
		Optional<Course> cr =  courseDao.findById(courseId);
		return cr.get();
	}

	@Override
	public Course addCourse(Course course) {

//		list.add(course);
		//return course;
		
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {

//		list.forEach(e -> {
//			if (e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});

		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
//		list = list.stream().filter(e -> e.getId() != parseLong).collect(Collectors.toList());
		
		courseDao.deleteById(parseLong);
//		courseDao.delete(cr);
	}

}
