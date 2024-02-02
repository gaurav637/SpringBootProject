package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.service;

@RestController
public class HomeController {
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private service sr;
	
	@GetMapping("/")
	public String index() {
		return "Welcome to spring boot crud application!";
	}
	
	
	 @PostMapping("/Student")
	    public ResponseEntity<Student> addStudent(@RequestBody Student student){
	       Student b = null;
	       try{
	        b = sr.addStudent(student);
	        return ResponseEntity.of(Optional.of(b));
	       }catch(Exception e){
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	       }
	    }
	
	
		//handle to fetch a single record
		@GetMapping("/Student/{rollNo}")
		public ResponseEntity<Student> getStudentData(@PathVariable int rollNo) {
			Student ans = sr.findById1(rollNo);
			if(ans==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(ans);
		
		}
		
	
		@GetMapping("/Student")
		public ResponseEntity<List<Student>> getAll() {
			List<Student> ans = sr.getAllStudent();
			if(ans.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(ans);
		}
	
	
		//Handle for delete a particular record from db
		@DeleteMapping("/Student/{rollNo}")
		public ResponseEntity<Void> deleteStudent(@PathVariable int rollNo) {
			try {
				sr.deleteByIdStudent(rollNo);
				return ResponseEntity.status(HttpStatus.NOT_EXTENDED).build();
				
			}catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
	
	
		@PutMapping("/Student")
		public ResponseEntity<Student> updateStudentData(@RequestBody Student student,int id) {
			Student result = sr.studentUpdate(student,id);
			if(result==null) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(result);	
		}	
		
}
