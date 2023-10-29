package com.example.gart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.gart.service.GartDataService;
import java.util.List;

@RestController
@RequestMapping("/api/gart-data")
public class GartDataController {
    @Autowired
    private GartDataService gartDataService;

    @GetMapping("/culture-names")
    public ResponseEntity<List<String>> getAllCultureNames() {
        List<String> cultureNames = gartDataService.getAllCultureNames();
        return new ResponseEntity<>(cultureNames, HttpStatus.OK);
    }
}
