package com.example.demo.service.impl;

import com.example.demo.model.AnalysisLog;
import org.springframework.stereotype.Service;

@Service
public class AnalysisLogServiceImpl {

    public void createLog(AnalysisLog log, String content) {
        // This will now find the symbol 'setMessage'
        log.setMessage(content);
    }
}