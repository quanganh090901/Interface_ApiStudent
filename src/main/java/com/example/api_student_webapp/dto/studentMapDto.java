package com.example.api_student_webapp.dto;

import java.util.List;

public class studentMapDto {
    private Integer numberOfItems;
    private List<studentDto> dtoList;

    public studentMapDto() {
    }

    public studentMapDto(Integer numberOfItems, List<studentDto> dtoList) {
        this.numberOfItems = numberOfItems;
        this.dtoList = dtoList;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public List<studentDto> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<studentDto> dtoList) {
        this.dtoList = dtoList;
    }
}
