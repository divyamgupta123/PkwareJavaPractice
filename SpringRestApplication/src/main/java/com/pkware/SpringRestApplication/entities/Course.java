package com.pkware.SpringRestApplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
	
	@Id
	private long id;
	private String title;
	private String description;

	public Course(long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", desciption=" + description + ", getId()=" + getId()
				+ ", getTitle()=" + getTitle() + ", getDesciption()=" + getDescription() + "]";
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desciption) {
		this.description = desciption;
	}

	public Course() {
		super();
	}
}
