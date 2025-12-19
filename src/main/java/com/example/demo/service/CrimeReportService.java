package com.example.demo.service;

import com.example.demo.model.CrimeReport;
import java.util.List;

public interface CrimeReportService {

    CrimeReport save(CrimeReport report);

    List<CrimeReport> getAll();
}
