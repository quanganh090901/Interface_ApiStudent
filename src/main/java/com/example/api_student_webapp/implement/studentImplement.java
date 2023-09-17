package com.example.api_student_webapp.implement;

import com.example.api_student_webapp.CustomRepo.studentCustomRepo;
import com.example.api_student_webapp.converter.studentConverter;
import com.example.api_student_webapp.dto.classDto;
import com.example.api_student_webapp.dto.classMapDto;
import com.example.api_student_webapp.dto.studentDto;
import com.example.api_student_webapp.dto.studentMapDto;
import com.example.api_student_webapp.models.studentEntity;
import com.example.api_student_webapp.service.studentService;
import com.example.api_student_webapp.studentRepositories.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class studentImplement implements studentService {
    @Autowired
    public studentRepository studentRepository;

    @Autowired
    public studentConverter studentConverter;

    @Autowired
    studentCustomRepo studentCustomRepo;

    @Override
    public studentDto save(studentDto studentDto) {
        studentEntity studentEntity = new studentEntity();
        if(studentDto.getId() != null){
            studentEntity oldStudentEntity = studentRepository.findById((int) studentDto.getId()).get();
            studentEntity = studentConverter.toEntity(studentDto, oldStudentEntity);
        }else {
            studentEntity = studentConverter.toEntity(studentDto);
        }
//        studentEntity studentEntity = studentConverter.toEntity(studentDto);
        studentEntity = studentRepository.save(studentEntity);
        return studentConverter.toDto(studentEntity);
    }

    @Override
    public void deleteById(int studentId) {
        try {
            studentRepository.deleteById(studentId);
        }catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public studentMapDto search(studentDto studentDto, Pageable pageable) {
        studentMapDto studentMapDto = new studentMapDto();
        studentMapDto.setNumberOfItems(studentCustomRepo.getNumberOfItemsByRequest(studentDto));
        List<studentDto> entities = studentCustomRepo.search(studentDto, pageable);
        studentMapDto.setDtoList(entities);
        return studentMapDto;
    }

//    @Override
//    public studentDto update(studentDto studentDto) {
//        studentEntity oldStudentEntity = studentRepository.findById((int) studentDto.getId()).get();
//        studentEntity studentEntity = studentConverter.toEntity(studentDto, oldStudentEntity);
//        studentEntity = studentRepository.save(studentEntity);
//        return studentConverter.toDto(studentEntity);
//    }

//    @Override
//    public List<studentDto> findAll(Pageable pageable) {
//        List<studentDto> results = new ArrayList<>();
//        List<studentEntity> entities = studentRepository.findAll((Sort) pageable);
//        for (studentEntity item: entities){
//            studentDto studentDto = studentConverter.toDto(item);
//            results.add(studentDto);
//        }
//        if (results.size() == 0) {
//            return null;
//        }
//        return results;
//    }

//    @Override
//    public int totalItem() {
//        return (int) studentRepository.count();
//    }

}
