package com.example.api_student_webapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "lophoc")

public class classEntity {

        //This is primary key
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
        @Column(name = "ma_lop")
        private Integer id;

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

        @Column(name = "TenLop")
        private String tenLop;
}
