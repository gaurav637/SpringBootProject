package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.service;

@Service
public class serviceImpl implements service {

	@Autowired
	private StudentRepository studentrepository;
	
	@Override
	public Student findById1(int rollNo) {
		Student result = null;
		try {
			result = studentrepository.findById(rollNo);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}


	@Override
	public List<Student> getAllStudent() {
		
		return studentrepository.findAll();
	}


	@Override
	public void deleteByIdStudent(int rollNo) {
		studentrepository.deleteById(rollNo);
		
	}


	@Override
	public Student studentUpdate(Student student,int id) {
		int n = student.getRollNo();
		
		if(n==id) {
			 Student ans = studentrepository.save(student);
			 return ans;
		}
		
		return null;
	}



	@Override
	public Student addBook(Student student) {
		Student st = studentrepository.save(student);
		return st;
	}

}
