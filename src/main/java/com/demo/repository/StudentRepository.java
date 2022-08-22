package com.demo.repository;

import java.util.List;

import com.demo.models.Students;

public interface StudentRepository 
{
	public void submitStudent(Students student);
	
	public void createTable();
	
	public Students findById(int id);
	
	public List<Students> findAll();
	
	public void updateStudent(Students student, int id);
	
	public void deleteStudentById(int id);
}
