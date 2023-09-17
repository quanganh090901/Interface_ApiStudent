package com.example.api_student_webapp.studentRepositories;

import com.example.api_student_webapp.models.studentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<studentEntity, Integer> {

}
