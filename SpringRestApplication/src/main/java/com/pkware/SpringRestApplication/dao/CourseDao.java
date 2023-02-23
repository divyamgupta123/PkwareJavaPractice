package com.pkware.SpringRestApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pkware.SpringRestApplication.entities.Course;

public interface CourseDao extends  JpaRepository<Course, Long>{

}
