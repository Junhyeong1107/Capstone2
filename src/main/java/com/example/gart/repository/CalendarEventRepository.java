package com.example.gart.repository;

import com.example.gart.entity.GartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CalendarEventRepository extends JpaRepository<GartData, Long> {
    @Query("SELECT c FROM GartData c WHERE c.startDate <= :date AND c.endDate >= :date")
    List<GartData> findEventsOnDate(@Param("date") LocalDate date);
}

