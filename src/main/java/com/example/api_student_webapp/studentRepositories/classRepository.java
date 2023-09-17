package com.example.api_student_webapp.studentRepositories;

import com.example.api_student_webapp.models.classEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface classRepository extends JpaRepository<classEntity, Integer> {
}
