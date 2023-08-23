package com.example.stdmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.stdmanagement.model.Student;
import com.example.stdmanagement.repository.StudentRepository;

@SpringBootApplication
public class ReactStudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReactStudentManagementSystemApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
//		Student student = new Student();
//		student.setFirstName("John");
//		student.setLastName("Aribatise");
//		student.setEmail("john@gmail.com");
//		student.setMatricNo("LCU/UG/21/20560");
//		studentRepository.save(student);
	}

}
