import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "crime_reports")
class CrimeReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String crimeType; 

    private String description; 

    @Min(-90) @Max(90)
    private Double latitude;

    @Min(-180) @Max(180)
    private Double longitude; 

    @PastOrPresent
    private LocalDateTime occurredAt;

    public CrimeReport() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCrimeType() { return crimeType; }
    public void setCrimeType(String crimeType) { this.crimeType = crimeType; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public LocalDateTime getOccurredAt() { return occurredAt; }
    public void setOccurredAt(LocalDateTime occurredAt) { this.occurredAt = occurredAt; }
}
@Repository
interface CrimeReportRepository extends JpaRepository<CrimeReport, Long> {}

@Service
class CrimeReportService {
    private final CrimeReportRepository repository;

    public CrimeReportService(CrimeReportRepository repository) {
        this.repository = repository;
    }

    public CrimeReport saveReport(CrimeReport report) {
        return repository.save(report);
    }

    public List<CrimeReport> getAllReports() {
        return repository.findAll();
    }
}
@RestController
@RequestMapping("/api/crimes")
class CrimeReportController {
    private final CrimeReportService service;

    public CrimeReportController(CrimeReportService service) {
        this.service = service;
    }

    @PostMapping
    public CrimeReport createReport(@Valid @RequestBody CrimeReport report) {
        return service.saveReport(report);
    }

    @GetMapping
    public List<CrimeReport> getReports() {
        return service.getAllReports();
    }
}