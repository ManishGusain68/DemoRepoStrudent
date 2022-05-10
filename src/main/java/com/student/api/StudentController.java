package com.student.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;
import com.student.service.StudentServiceImpl;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudent(){
		System.out.println(service.getClass());
		List<Student> allStudent = service.getAllStudent();
		return new ResponseEntity<List<Student>>(allStudent,HttpStatus.OK);
		
	}

}
