package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.demo.models.StudentRowMapper;
import com.demo.models.Students;

@Service
public class StudentService
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void submitStudent(Students student) 
	{
		this.jdbcTemplate.update("insert into students(id,name,age,phone)values('"+student.getId()+"','"+student.getName()+"','"+student.getAge()+"', '"+student.getPhone()+"')");
	}
	
	public void createTable() 
	{
		this.jdbcTemplate.execute("create table students(id int, name varchar(255), age int, phone  varchar(255) )");
	}
	
	public Students findById(int id) 
	{
		Students student = this.jdbcTemplate.query("select * from students where id = ?", new StudentRowMapper(), id).get(0);
		return student;
	}
	
	public List<Students> findAll() 
	{
		List<Students> studnetList = this.jdbcTemplate.query("select * from students", new StudentRowMapper());
		return studnetList;
	}
	
	public void updateStudent(Students student, int id) 
	{
		this.jdbcTemplate.execute("update students set name='"+student.getName()+"', age='"+student.getAge()+"', phone='"+student.getPhone()+"' where id="+id);
	}
	
	public void deleteStudentById(int id) 
	{
		this.jdbcTemplate.update("delete from students where id="+id);
	}
}
