package com.example.api_student_webapp.converter;

import com.example.api_student_webapp.dto.classDto;
import com.example.api_student_webapp.models.classEntity;
import org.springframework.stereotype.Component;

@Component
public class classConverter {
    public classEntity toEntity(classDto dto){
        classEntity entity = new classEntity();
        entity.setId(dto.getId());
        entity.setTenLop(dto.getTenLop());
        return entity;
    }

    public classDto toDto(classEntity entity){
        classDto dto = new classDto();
        dto.setId(entity.getId());
        dto.setTenLop(entity.getTenLop());
        return dto;
    }

    public classEntity toEntity(classDto dto, classEntity entity){
        entity.setId(dto.getId());
        entity.setTenLop(dto.getTenLop());
        return entity;
    }
}
