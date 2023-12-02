package com.example.gart.repository;

import com.example.gart.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.gart.dto.ImageDataDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

// ImageRepository.java
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query("SELECT new com.example.gart.dto.ImageDataDto(d.cultureName, i.filePath) FROM Image i JOIN GartData d ON i.gartDataId = d.id WHERE d.cultureName = :name")
    Optional<ImageDataDto> findImageByTitle(@Param("name") String name);
}
