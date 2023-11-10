package com.example.gart.entity;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "gart_data")
public class CalendarEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "name", nullable = false)
    private String name;

    // 기존의 getName()과 setName() 메소드

    // id 필드에 대한 getter
    public Long getId() {
        return id;
    }

    // id 필드에 대한 setter
    public void setId(Long id) {
        this.id = id;
    }

    // startDate 필드에 대한 getter
    public LocalDate getStartDate() {
        return startDate;
    }

    // startDate 필드에 대한 setter
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    // endDate 필드에 대한 getter
    public LocalDate getEndDate() {
        return endDate;
    }

    // endDate 필드에 대한 setter
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // name 필드에 대한 getter와 setter는 이미 있음
}

