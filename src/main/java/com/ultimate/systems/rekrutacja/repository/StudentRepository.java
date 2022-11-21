package com.ultimate.systems.rekrutacja.repository;

import com.ultimate.systems.rekrutacja.DTO.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
