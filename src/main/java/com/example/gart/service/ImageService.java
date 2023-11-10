package com.example.gart.service;

import com.example.gart.entity.Image;
import com.example.gart.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import com.example.gart.exception.ResourceNotFoundException;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image saveImage(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path filePath = Paths.get("images").resolve(fileName).normalize();
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        Image image = new Image();
        image.setFileName(fileName);
        image.setFilePath(filePath.toString());
        return imageRepository.save(image);
    }

    public Resource loadImage(Long imageId) throws MalformedURLException {
        Image image = imageRepository.findById(imageId)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id " + imageId));
        Path filePath = Paths.get(image.getFilePath()).normalize();
        return new UrlResource(filePath.toUri());
    }
}
