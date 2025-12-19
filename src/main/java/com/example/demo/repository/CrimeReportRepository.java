package com.example.demo.repository;

import com.example.demo.model.CrimeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CrimeReportRepository extends JpaRepository<CrimeReport, Long> {

    @Query("""
        SELECT c FROM CrimeReport c
        WHERE c.latitude BETWEEN :latMin AND :latMax
          AND c.longitude BETWEEN :lonMin AND :lonMax
    """)
    List<CrimeReport> findInArea(
            double latMin,
            double latMax,
            double lonMin,
            double lonMax
    );
}
