package backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import backend.service.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Get a patient by id 
    @GetMapping("/{id}")
    public ResponseEntity<String> getPatient(@PathVariable("id") String id) {
        String patientData = patientService.getPatientData(id);
        return ResponseEntity.ok(patientData);
    }

    // Add a patient
    @PostMapping("/")
    public ResponseEntity<String> addPatient(@RequestBody String patientData) {
        String result = patientService.addPatientData(patientData);
        return ResponseEntity.ok(result);
    }
}