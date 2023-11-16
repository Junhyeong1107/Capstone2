package com.example.gart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gart.repository.GartDataRepository;
import java.util.List;


@Service
public class GartDataService {
    @Autowired
    private GartDataRepository gartDataRepository;

    public List<String> getAllCultureNames() {
        return gartDataRepository.findAllCultureNames();
    }

    public List<String> getCultureNamesByCategory(String category) {
        return gartDataRepository.findCultureNamesByCategory(category);
    }
    public List<String> getCultureNamesByKeyword(String keyword) {
        return gartDataRepository.getCultureNamesByKeyword(keyword);
    }
}
