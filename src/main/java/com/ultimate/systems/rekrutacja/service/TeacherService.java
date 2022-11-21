package com.ultimate.systems.rekrutacja.service;

import com.ultimate.systems.rekrutacja.DTO.Teacher;
import com.ultimate.systems.rekrutacja.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TeacherService {

    final TeacherRepository teacherRepository;

    public ResponseEntity<Teacher> save(Teacher teacher){

        Teacher savedTeacher = teacherRepository.save(teacher);
        return ResponseEntity.created(URI.create("/api/teacher/" +savedTeacher.getId())).build();
    }

    public ResponseEntity<List<Teacher>> getAllTeachers(){
        List<Teacher> teachers = teacherRepository.findAll();

        if(teachers.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(teachers);
    }

    public ResponseEntity<Long> updateTeacher(long id, Teacher newTeacher){
        Optional<Teacher> teacherData = teacherRepository.findById(id);

        if(teacherData.isPresent()){
            Teacher tmp = teacherData.get();
            tmp.setName(newTeacher.getName());
            tmp.setSurname(newTeacher.getSurname());
            tmp.setEmail(newTeacher.getEmail());
            tmp.setAge(newTeacher.getAge());
            tmp.setSubject(newTeacher.getSubject());
            tmp.setStudents(newTeacher.getStudents());

            Teacher savedTeacher = teacherRepository.save(tmp);
            return ResponseEntity.ok(savedTeacher.getId());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<HttpStatus> deleteTeacher(long id){
        try{
            teacherRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
