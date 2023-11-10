package com.example.gart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gart.entity.GartData;
import com.example.gart.repository.GartDataRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GartDataService {

    
    @Autowired
    private GartDataRepository gartDataRepository;

    public List<String> getAllCultureNames() {
        List<GartData> dataList = gartDataRepository.findAll();
        return dataList.stream().map(GartData::getCultureName).collect(Collectors.toList());
    }
}
