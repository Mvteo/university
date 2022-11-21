package com.ultimate.systems.rekrutacja.controller;


import com.ultimate.systems.rekrutacja.DTO.Teacher;
import com.ultimate.systems.rekrutacja.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherController {

    public final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher){
        return teacherService.save(teacher);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Long> updateTeacher(@PathVariable Long id, @RequestBody Teacher newTeacher){
        return teacherService.updateTeacher(id,newTeacher);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTeacher(@PathVariable long id){
        return teacherService.deleteTeacher(id);
    }



}
