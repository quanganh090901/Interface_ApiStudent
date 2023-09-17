package com.example.api_student_webapp.models;
import jakarta.persistence.*;

@Entity
@Table(name = "hocsinh")
public class studentEntity {
    //This is primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    @Column(name = "MaHS")
    private Integer id;
    @Column(name = "HoTen")
    private String HoTen;
    @Column(name = "GioiTinh")
    private String GioiTinh;
    @Column(name = "NgaySinh")
    private Integer NgaySinh;
    @Column(name = "DiaChi")
    private String DiaChi;
    @Column(name = "ma_lop")
    private Integer MaLop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_lop", insertable = false, updatable = false)
    private classEntity  classEntity;

    public studentEntity() {
    }

    public studentEntity(String hoTen, String gioiTinh, Integer ngaySinh, String diaChi, Integer maLop) {
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

    public Integer getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Integer ngaySinh) {
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
