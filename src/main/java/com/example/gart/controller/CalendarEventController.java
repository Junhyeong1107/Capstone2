package com.example.gart.controller;

import com.example.gart.entity.GartData;
import com.example.gart.repository.CalendarEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/gart")
public class CalendarEventController {
    @Autowired
    private CalendarEventRepository repository;

    @GetMapping("/event")
    public List<GartData> getEventsWithinDate(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return repository.findEventsOnDate(date);
    }

}

