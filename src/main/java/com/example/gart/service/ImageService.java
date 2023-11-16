package com.example.gart.service;

import com.example.gart.entity.Image;
import com.example.gart.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }
}

