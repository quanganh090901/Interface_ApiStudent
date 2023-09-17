package com.example.api_student_webapp.service;

import com.example.api_student_webapp.dto.classDto;
import com.example.api_student_webapp.dto.classMapDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface classService {

    List<classDto> getAll();
    classDto save(classDto classDto);

    void deleteById(int classId);

    classMapDto search(classDto classDto, Pageable pageable);
}
