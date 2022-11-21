package com.ultimate.systems.rekrutacja.controller;

import com.ultimate.systems.rekrutacja.DTO.Student;
import com.ultimate.systems.rekrutacja.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Long> updateStudent(@PathVariable Long id, @RequestBody Student newTeacher){
        return studentService.updateStudent(id,newTeacher);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }

}
