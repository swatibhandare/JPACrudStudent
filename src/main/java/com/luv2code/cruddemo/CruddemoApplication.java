package com.luv2code.cruddemo;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.luv2code.cruddemo.Entity.Student;
import com.luv2code.cruddemo.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner cpmmandLineRunner(StudentDAO studentDAO){
		return runner -> {
			System.out.println("Hello world");
			createStudent(studentDAO);
			readStudent(studentDAO);
			getStudentList(studentDAO);
			updateStudent(studentDAO);
			deleteStudentRecord(studentDAO);
		};
	}

	private void deleteStudentRecord(StudentDAO studentDAO) {
		studentDAO.deleteStudent(2);
	}

	private void updateStudent(StudentDAO studentDAO) {
	Student s = studentDAO.findById(1);
	//studentDAO.updateStudent(s);
	System.out.println("s updated as:" +s.toString());
	}

	private void getStudentList(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		System.out.println("All Student:" +studentList.toString());
	}

	private void readStudent(StudentDAO studentDAO) {
		//Student s1 = studentDAO.findById(1);
		//System.out.println("read student=" + s1.getFirstName());
	}

	private void createStudent(StudentDAO studentDAO) {
		Student s = new Student("John1", "Smith", "john@gmail.com");
		studentDAO.save(s);
		System.out.println("Generated student:" + s.toString());
	}
}
