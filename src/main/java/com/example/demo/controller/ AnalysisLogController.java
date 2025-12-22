package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
@Tag(name = "Analysis Logs")
public class AnalysisLogController {

    @PostMapping("/{zoneId}")
    public String add(@PathVariable Long zoneId) {
        return "Log added";
    }

    @GetMapping("/zone/{zoneId}")
    public String get(@PathVariable Long zoneId) {
        return "Logs fetched";
    }
}
cd /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/
mv " AnalysisLogController.java" AnalysisLogController.java
mv " HotspotZoneController.java" HotspotZoneController.java

cd /home/coder/Workspace/demo/src/main/java/com/example/demo/service/
mv " AnalysisLogService.java" AnalysisLogService.java
mv " PatternDetectionService.java" PatternDetectionService.java