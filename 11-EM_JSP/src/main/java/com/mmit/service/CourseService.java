package com.mmit.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mmit.entity.Course;

public class CourseService {
	private EntityManager em;
	public CourseService(EntityManager em) {
		this.em=em;
	}
	public void saveCourse(Course course) {
		em.getTransaction().begin();
		em.persist(course);
		
		em.getTransaction().commit();
		
	}
	public List<Course> findAll() {
		TypedQuery<Course> query=em.createQuery("SELECT c FROM Course c", Course.class);
		List<Course> list=query.getResultList();
		return list;
	}

}
