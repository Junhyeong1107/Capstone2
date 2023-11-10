package com.example.gart.controller;

import com.example.gart.entity.CalendarEvent;
import com.example.gart.repository.CalendarEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class CalendarEventController {
    @Autowired
    private CalendarEventRepository repository;

    @GetMapping("/range")
    public List<CalendarEvent> getEventsWithinDate(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return repository.findEventsOnDate(date);
    }

    // 기존 메소드들...
}

