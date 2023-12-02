package com.example.gart.controller;

import com.example.gart.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@CrossOrigin(origins = "*")
@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/gart/image")
    public ResponseEntity<byte[]> getImageByTitle(@RequestParam String title) {
        byte[] imageData = imageService.getImageByTitle(title);
        return ResponseEntity.ok()
                             .contentType(MediaType.IMAGE_JPEG) // Adjust the MediaType if needed
                             .body(imageData);
    }
}
