package com.example.api_student_webapp.dto;

import jakarta.persistence.Column;

import java.util.List;

public class classDto {
    private Integer id;
    private String tenLop;
    private List<classDto> listClassDto;

    public List<classDto> getListClassDto() {
        return listClassDto;
    }

    public void setListClassDto(List<classDto> listClassDto) {
        this.listClassDto = listClassDto;
    }

    public classDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public classDto(Integer id, String tenLop) {
        this.id = id;
        this.tenLop = tenLop;
    }
}
