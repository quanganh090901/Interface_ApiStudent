package com.example.api_student_webapp.dto;

import jakarta.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class studentDto {
    private Integer id;
    private String HoTen;
    private String GioiTinh;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date NgaySinh;
    private String DiaChi;
    private Integer MaLop;

    public List<studentDto> getListStudentDto() {
        return listStudentDto;
    }

    public void setListStudentDto(List<studentDto> listStudentDto) {
        this.listStudentDto = listStudentDto;
    }

    private List<studentDto> listStudentDto;

    public studentDto() {
    }

    public studentDto(String hoTen, String gioiTinh, Date ngaySinh, String diaChi, Integer maLop) {
        HoTen = hoTen;
        GioiTinh = gioiTinh;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        MaLop = maLop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public Integer getMaLop() {
        return MaLop;
    }

    public void setMaLop(Integer maLop) {
        MaLop = maLop;
    }
}
