package com.example.gart.service;

import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gart.dto.ImageDataDto;
import com.example.gart.repository.ImageRepository;

import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ImageServiceImpl implements ImageService {
    
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public byte[] getImageByTitle(String title) {
    // Fetch the image data (including file path) using the title
        ImageDataDto imageDataDto = imageRepository.findImageByTitle(title)
                .orElseThrow(() -> new RuntimeException("Image not found with title: " + title));

    // Extract file path from the imageDataDto
    String filePath = imageDataDto.getFilePath();

    // Read the file from the file system
    try {
        Path path = Paths.get(filePath);
        return Files.readAllBytes(path);
    } catch (IOException e) {
        throw new RuntimeException("Error occurred while reading the image file", e);
    }
}

}
