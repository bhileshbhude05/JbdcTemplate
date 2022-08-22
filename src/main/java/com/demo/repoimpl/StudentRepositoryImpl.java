package com.demo.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.models.StudentRowMapper;
import com.demo.models.Students;
import com.demo.repository.StudentRepository;
import com.demo.service.StudentService;

@Repository
public class StudentRepositoryImpl implements StudentRepository
{
	@Autowired
	private StudentService studentService;
	
	@Override
	public void submitStudent(Students student) 
	{
		this.studentService.submitStudent(student);
		System.out.println("Record Submitted Successfully !!");
	}

	@Override
	public void createTable() 
	{
		this.studentService.createTable();
		System.out.println("Table Created !!"); 
	}

	@Override
	public Students findById(int id) 
	{
		Students student = this.studentService.findById(id);
		return student;
	} 

	@Override
	public List<Students> findAll() 
	{
		List<Students> studnetList = this.studentService.findAll();
		return studnetList;
	}

	@Override
	public void updateStudent(Students student, int id) 
	{
		this.studentService.updateStudent(student, id);
		System.out.println("Record Updated Successfully !!"); 
	}

	@Override
	public void deleteStudentById(int id) 
	{
		this.studentService.deleteStudentById(id);
		System.out.println("Record Deleted !!");
	}

}
