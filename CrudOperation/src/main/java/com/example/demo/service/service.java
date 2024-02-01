package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Student;

@Component
public interface service {
	


	public Student findById1(int rollNo);

	public List<Student> getAllStudent();

	public void deleteByIdStudent(int rollNo);

	public Student studentUpdate(Student student,int id);

	public Student addStudent(Student student);
}
