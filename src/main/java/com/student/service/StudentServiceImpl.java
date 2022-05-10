package com.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentrepo;
	@Autowired
	RestTemplate restTemp;

	@Override
	public List<Student> getAllStudent() {
		System.out.println(studentrepo.getClass());
		System.out.println(restTemp);
		List<Student> allstudent=new ArrayList<Student>();
		studentrepo.findAll().forEach(e->allstudent.add(e));
		return allstudent;
		
	}

}
