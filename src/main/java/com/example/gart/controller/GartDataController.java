package com.example.gart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.gart.service.GartDataService;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/gart")
public class GartDataController {
    @Autowired
    private GartDataService gartDataService;

    @GetMapping("/culture-names")
    public ResponseEntity<List<String>> getAllCultureNames(
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "keyword", required = false) String keyword) {
        List<String> cultureNames;

        if (category != null && !category.isEmpty()) {
            cultureNames = gartDataService.getCultureNamesByCategory(category);
        } else if (keyword != null && !keyword.isEmpty()) {
            cultureNames = gartDataService.getCultureNamesByKeyword(keyword);
        } else {
            cultureNames = gartDataService.getAllCultureNames();
        }
        return new ResponseEntity<>(cultureNames, HttpStatus.OK);
    }

    @GetMapping("/url")
    public ResponseEntity<String> getUrlByName(@RequestParam String name) {
        String url = gartDataService.getUrlByName(name);
        if (url != null) {
            return ResponseEntity.ok(url);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("URL not found for the given name.");
        }
    }
}
