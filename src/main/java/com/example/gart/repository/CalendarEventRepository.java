package com.example.gart.repository;

import com.example.gart.entity.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {
    @Query("SELECT c FROM CalendarEvent c WHERE c.startDate <= :date AND c.endDate >= :date")
    List<CalendarEvent> findEventsOnDate(@Param("date") LocalDate date);
}

