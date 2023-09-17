package com.example.api_student_webapp.implement;

import com.example.api_student_webapp.CustomRepo.classCustomRepo;
import com.example.api_student_webapp.converter.classConverter;
import com.example.api_student_webapp.dto.classDto;
import com.example.api_student_webapp.dto.classMapDto;
import com.example.api_student_webapp.models.classEntity;
import com.example.api_student_webapp.service.classService;
import com.example.api_student_webapp.studentRepositories.classRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class classImp implements classService {

    @Autowired
    private classRepository classRepository;
    @Autowired
    private classConverter classConverter;

    @Autowired
    private classCustomRepo classCustomRepo;


    @Override
    public List<classDto> getAll() {
        List<classEntity> result = (List<classEntity>) classRepository.findAll();

        return result.stream().map(this::converClassEntityToDto).collect(Collectors.toList());
    }

    @Override
    public classDto save(classDto classDto) {
        classEntity classEntity = new classEntity();
        if(classDto.getId() != null){
            classEntity oldClassEntity = classRepository.findById((int) classDto.getId()).get();
            classEntity = classConverter.toEntity(classDto, oldClassEntity);
        }else {
            classEntity = classConverter.toEntity(classDto);
        }
//        studentEntity studentEntity = studentConverter.toEntity(studentDto);
        classEntity = classRepository.save(classEntity);
        return classConverter.toDto(classEntity);
    }

    @Override
    public void deleteById(int classId) {
        try {
            classRepository.deleteById(classId);
        }catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public classMapDto search(classDto classDto, Pageable pageable) {
        classMapDto classMapDto = new classMapDto();
        classMapDto.setNumberOfItems(classCustomRepo.getNumberOfItemsByRequest(classDto));
        List<classDto> entities = classCustomRepo.search(classDto, pageable);
        classMapDto.setList(entities);
        return classMapDto;
    }

    private classDto converClassEntityToDto(classEntity classEntity){
        classDto dto = new classDto();
        dto.setId(classEntity.getId());
        dto.setTenLop(classEntity.getTenLop());
        return dto;
    }
}
