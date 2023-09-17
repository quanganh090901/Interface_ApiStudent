package com.example.api_student_webapp.service;

import com.example.api_student_webapp.dto.classDto;
import com.example.api_student_webapp.dto.classMapDto;
import com.example.api_student_webapp.dto.studentDto;
import com.example.api_student_webapp.dto.studentMapDto;
import com.example.api_student_webapp.models.studentEntity;
import org.springframework.data.domain.Pageable;

public interface studentService {

//    studentEntity findAll(studentEntity studentEntity);
    studentDto save(studentDto studentDto);

    void deleteById(int studentId);

//    studentDto update(studentDto studentDto);
    studentMapDto search(studentDto studentDto, Pageable pageable);

}
