package com.example.gart.controller;

import com.example.gart.entity.Image;
import com.example.gart.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = "*")
@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/gart/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        Image image = imageService.getImageById(id);

        if (image == null) {
            return ResponseEntity.notFound().build();
        }

        Path path = Paths.get(image.getFilePath());
        byte[] imageBytes = Files.readAllBytes(path);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }
}
