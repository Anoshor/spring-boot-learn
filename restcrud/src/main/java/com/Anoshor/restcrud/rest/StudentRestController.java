package com.Anoshor.restcrud.rest;

import com.Anoshor.restcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // Initialize the student list
    private List<Student> studentList;

    @PostConstruct //data always loads post construct, no need to define constructor explicitly
    public void loadData() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Anoshor", "Paul"));
        studentList.add(new Student("Ano", "Paulermo"));
        studentList.add(new Student("Ash", "Ketchum"));
    }

    // Define endpoint for students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    // Define endpoint to get a specific student by ID (index)
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) { //add path variable!!!
        if (studentId >= 0 && studentId < studentList.size()) {
            return studentList.get(studentId);
        } else {
            throw new StudentNotFoundException("Student Not Found- " + studentId);
        }
    }


}
