package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.Students;
import com.demo.repoimpl.StudentRepositoryImpl;

@RestController
public class StudentController 
{
	@Autowired
	private StudentRepositoryImpl studentRepositoryImpl;
	
	@PostMapping("/student")
	public ResponseEntity<?> submitStd(@RequestBody Students student)
	{
		this.studentRepositoryImpl.submitStudent(student);
		return ResponseEntity.ok("Record Submitted Successfully !!"); 
	}
	
	@GetMapping("/")
	public ResponseEntity<?> createTable()
	{
		this.studentRepositoryImpl.createTable();
		return ResponseEntity.ok("Table Created");
	}
	
	@GetMapping("/student/{id}") 
	public ResponseEntity<?> getStudent(@PathVariable("id") int id)
	{
		Students student = this.studentRepositoryImpl.findById(id);
		return ResponseEntity.ok(student);
	}
	
	@GetMapping("/allStudent")
	public ResponseEntity<?> getAllStudents()
	{
		List<Students> studentList = this.studentRepositoryImpl.findAll();
		return ResponseEntity.ok(studentList);
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<?> getUpdate(@RequestBody Students student, @PathVariable int id)
	{
		this.studentRepositoryImpl.updateStudent(student, id);
		return ResponseEntity.ok("Record Updated Successfully !!");
	}
	
	@DeleteMapping("/deleteStd/{id}")
	public ResponseEntity<?> getStudentDeleteById(@PathVariable int id)
	{
		this.studentRepositoryImpl.deleteStudentById(id);
		return ResponseEntity.ok("Record Deleted Successfully !!");
	}
}
