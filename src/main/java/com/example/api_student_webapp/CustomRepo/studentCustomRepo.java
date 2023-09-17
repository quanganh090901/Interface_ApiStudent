package com.example.api_student_webapp.CustomRepo;

import com.example.api_student_webapp.dto.studentDto;
import com.example.api_student_webapp.models.studentEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface studentCustomRepo {
    List<studentEntity> getById(Integer studentId);

    List<studentEntity> getByEmpId(Integer studentId);

    Integer getNumberOfItemsByRequest(studentDto studentDto);

    List<studentDto> search(studentDto studentDto, Pageable pageable);
}
