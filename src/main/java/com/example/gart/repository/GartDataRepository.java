package com.example.gart.repository;
import com.example.gart.entity.GartData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GartDataRepository extends JpaRepository<GartData, Long> {
}
