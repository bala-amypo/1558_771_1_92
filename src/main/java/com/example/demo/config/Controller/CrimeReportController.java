@RestController
@RequestMapping("/reports")
public class CrimeReportController {

    private final CrimeReportService service;

    public CrimeReportController(CrimeReportService service) {
        this.service = service;
    }

    @PostMapping
    public CrimeReport add(@RequestBody CrimeReport report) {
        return service.addReport(report);
    }

    @GetMapping
    public List<CrimeReport> all() {
        return service.getAllReports();
    }
}
