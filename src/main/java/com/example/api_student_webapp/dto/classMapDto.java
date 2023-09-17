package com.example.api_student_webapp.dto;

import java.util.List;

public class classMapDto {
    private Integer numberOfItems;
    private List<classDto> list;

    public classMapDto() {
    }

    public classMapDto(Integer numberOfItems, List<classDto> list) {
        this.numberOfItems = numberOfItems;
        this.list = list;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public List<classDto> getList() {
        return list;
    }

    public void setList(List<classDto> list) {
        this.list = list;
    }
}
