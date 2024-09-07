package com.MainApp.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MainApp.Entity.Student;
import com.MainApp.Repository.StudentRepository;

@RestController
public class HomeController {
	
	//get-read
	//post-insert
	//put-update
	//delete-dalete
	
	@Autowired
	StudentRepository sRepo;
	
	//localhost:8082/save ----> end point
	@PostMapping("/save")
	public String saveStudent(@RequestBody Student s) {
		sRepo.save(s);
		return "inserted";
	}
	
	//localhost:8082/readall
	@GetMapping("/readall")
	public List<Student> readAll(){
		return (List<Student>)sRepo.findAll();
	}
	
	@GetMapping("/readByRoll/{roll}")
	public Student readByRoll(@PathVariable("roll") int r) {
		return sRepo.findByRoll(r);
	}
	
	@DeleteMapping("/delete/{roll}")
	public String deleteByRoll(@PathVariable("roll") int r) {
		if(sRepo.findById(r)!=null) {
			sRepo.deleteById(r);
			return "deleted";
		}else {
			return "not exists";
		}
	}
	
	@PutMapping("/update")
	public String updateByRoll(@RequestBody Student s) {
		if(sRepo.findByRoll(s.getRoll_no()) != null) {
			sRepo.save(s);
			return "updated";
		}else {
			return "not Exists";
		}
	}
	
	@GetMapping("/check/{roll}/{name}")
	public String checkStudent(@PathVariable("roll")int r,@PathVariable("name") String n) {
		if(sRepo.findByRollAndName(r, n)!=null) {
			return "exist";
		}
		else {
			return "not Exsits";
		}
		
	}
	
}
