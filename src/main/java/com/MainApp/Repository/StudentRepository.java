package com.MainApp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MainApp.Entity.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	Student findByRoll(int r);
	
	Student findByRollAndName(int r,String n);
}
