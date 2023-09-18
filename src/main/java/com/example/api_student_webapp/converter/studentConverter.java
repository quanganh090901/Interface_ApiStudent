package com.example.api_student_webapp.converter;

import com.example.api_student_webapp.dto.studentDto;
import com.example.api_student_webapp.models.studentEntity;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class studentConverter {
    public studentEntity toEntity(studentDto dto){
        studentEntity entity = new studentEntity();
//        entity.setId(dto.getId());
        entity.setDiaChi(dto.getDiaChi());
        entity.setGioiTinh(dto.getGioiTinh());
        entity.setHoTen(dto.getHoTen());
        entity.setNgaySinh(dto.getNgaySinh());
        entity.setMaLop(dto.getMaLop());
        return entity;
    }

    public studentDto toDto(studentEntity entity){
        studentDto dto = new studentDto();
//        entity.setId(dto.getId());
        dto.setDiaChi(entity.getDiaChi());
        dto.setGioiTinh(entity.getGioiTinh());
        dto.setHoTen(entity.getHoTen());
        dto.setNgaySinh(entity.getNgaySinh());
        dto.setMaLop(entity.getMaLop());
        return dto;
    }

    public studentEntity toEntity(studentDto dto, studentEntity entity){
        entity.setNgaySinh(dto.getNgaySinh());
        entity.setDiaChi(dto.getDiaChi());
        entity.setGioiTinh(dto.getGioiTinh());
        entity.setMaLop(dto.getMaLop());
        entity.setHoTen(dto.getHoTen());
        return entity;
    }
}
