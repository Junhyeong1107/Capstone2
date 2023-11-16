package com.example.gart.repository;
import com.example.gart.entity.GartData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface GartDataRepository extends JpaRepository<GartData, Long> {
    @Query("SELECT g.cultureName FROM GartData g WHERE g.category = :category")
    List<String> findCultureNamesByCategory(@Param("category") String category);

    @Query("SELECT g.cultureName FROM GartData g")
    List<String> findAllCultureNames();
    
    @Query("SELECT g.cultureName FROM GartData g WHERE g.cultureName LIKE '%' || :keyword || '%'")
    List<String> getCultureNamesByKeyword(@Param("keyword") String keyword);
}
