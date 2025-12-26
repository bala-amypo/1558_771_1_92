package com.example.demo.repository;

import com.example.demo.model.CrimeReport;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface CrimeReportRepository extends JpaRepository<CrimeReport, Long> {

    @Query("SELECT c FROM CrimeReport c WHERE c.latitude BETWEEN ?1 AND ?2 AND c.longitude BETWEEN ?3 AND ?4")
    List<CrimeReport> findByLatLongRange(Double lat1, Double lat2, Double lon1, Double lon2);
}
