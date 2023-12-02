package com.example.gart.dto;


public class ImageDataDto {
    private String name;
    private String filePath;

        // 기본 생성자
        public ImageDataDto() {
        }
    
        // 모든 필드를 인자로 받는 생성자
        public ImageDataDto(String name, String filePath) {
            this.name = name;
            this.filePath = filePath;
        }
    
        // name 필드에 대한 getter
        public String getName() {
            return name;
        }
    
        // name 필드에 대한 setter
        public void setName(String name) {
            this.name = name;
        }
    
        // filePath 필드에 대한 getter
        public String getFilePath() {
            return filePath;
        }
    
        // filePath 필드에 대한 setter
        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }
}
   
