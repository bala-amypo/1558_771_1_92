package com.example.demo.repository;

import com.example.demo.model.CrimeReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrimeReportRepository extends JpaRepository<CrimeReport, Long> {

    List<CrimeReport> findByLatLongRange(
            double minLat,
            double maxLat,
            double minLong,
            double maxLong
    );
}
