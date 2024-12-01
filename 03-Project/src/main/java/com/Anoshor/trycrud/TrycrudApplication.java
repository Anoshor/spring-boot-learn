package com.Anoshor.trycrud;

import com.Anoshor.trycrud.dao.StudentDAO;
import com.Anoshor.trycrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TrycrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrycrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
				createStudent(studentDAO);
//			readStudent(studentDAO);
//			displayStudents(studentDAO);
//			findStudentByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int id = 2;
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve update and merge
		int id = 1;
		Student s = studentDAO.findById(id);
		s.setFirstName("Anos");

		studentDAO.update(s);
		System.out.println("Student database updated");
	}

	private void findStudentByLastName(StudentDAO studentDAO) {

		List<Student> s = studentDAO.findByLastName("Paul");
		for (Student student : s) {
			System.out.println(student);
		}
	}

	private void displayStudents(StudentDAO studentDAO) {

		List<Student> s = studentDAO.findAll();

		for (Student student : s) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		Student s1 = new Student("Blu", "Backer", "blu@gmail.com");
		//save the student
		studentDAO.save(s1);
		//display id
		int tempId = s1.getId();
		System.out.println("s1 ka id is : " + tempId);
		//retrieve and display

		Student s = studentDAO.findById(tempId);
		System.out.println("Found student " + s);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create student object and save
		System.out.println("Creating new student object");
		Student s1 = new Student("Anoshor", "Paul", "anoshorpaul@gmail.com");
		System.out.println("saving student...");
		studentDAO.save(s1);
		//display the id

		System.out.println("Saved student. Generated id: " + s1.getId());
	}

	public void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting All Students...");
		int x = studentDAO.deleteAll();
		System.out.println("Deleted row count : " + x);
	}
}
