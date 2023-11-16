package com.example.gart.entity;


import javax.persistence.*;
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "file_path", length = 255, nullable = false)
    private String filePath;

    // 생성자, getter, setter 생략
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
        public String getFilePath() {
        return filePath;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
