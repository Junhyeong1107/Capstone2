package com.example.gart.repository;

import com.example.gart.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepository extends JpaRepository<Image, Long> {
}
