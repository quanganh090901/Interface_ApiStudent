package com.example.api_student_webapp.CustomRepo;

import com.example.api_student_webapp.dto.classDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface classCustomRepo {
     List<classDto> search(classDto departmentDto, Pageable pageable);

     Integer getNumberOfItemsByRequest(classDto departmentDto);

    void delete(Integer id);
}
