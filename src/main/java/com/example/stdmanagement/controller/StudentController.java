package com.example.stdmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stdmanagement.exception.ResourceNotFoundException;
import com.example.stdmanagement.model.Student;
import com.example.stdmanagement.repository.StudentRepository;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	
	//GET HttpMethod
	@GetMapping
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	//build create student REST API
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	//build get student by Id REST API
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long id){
		Student student = studentRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Student with ID: " +id + " does not exist"));
		return ResponseEntity.ok(student);
	}
	
	//build update student REST API
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student studentDetails){
		//we first need to find the student by ID from the student repository
		Student updateStudent = studentRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Student not exist with id: "+id) );
		//after finding the student by ID , we need set attributes to our updateStudent object
		updateStudent.setFirstName(studentDetails.getFirstName());
		updateStudent.setLastName(studentDetails.getLastName());
		updateStudent.setEmail(studentDetails.getEmail());
		updateStudent.setMatricNo(studentDetails.getMatricNo());
		
		//then save the updateStudent to the studentRepository
		studentRepository.save(updateStudent);
		
		//return the http response entity
		return ResponseEntity.ok(updateStudent);
	}
	
	//build delete student REST API
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id){
		//we need to find the student with the chosen Id from the student repository
		Student deleteStudent = studentRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Student does not exist with id: "+id));
		studentRepository.delete(deleteStudent);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
}
