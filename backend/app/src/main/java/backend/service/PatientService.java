package backend.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

@Service
public class PatientService {
    private final Firestore firestore;
    private final ObjectMapper objectMapper;

    @Autowired
    public PatientService(Firestore firestore) {
        this.firestore = firestore;
        this.objectMapper = new ObjectMapper();
    }

    public String getPatientData(String id) {
        try {
            // Get reference to the patient document
            ApiFuture<DocumentSnapshot> future = firestore.collection("patients").document(id).get();
            DocumentSnapshot document = future.get();
            
            if (document.exists()) {
                return document.getData().toString();
            } else {
                return "Patient not found with id: " + id;
            }
        } catch (Exception e) {
            return "Error fetching patient data: " + e.getMessage();
        }
    }

    public String addPatientData(String patientData) {
        try {
            // Convert JSON string to Map
            Map<String, Object> data = objectMapper.readValue(patientData, new TypeReference<Map<String, Object>>() {});
            
            // Create a new document with auto-generated ID
            ApiFuture<WriteResult> future = firestore.collection("patients")
                .document()
                .set(data);
            
            WriteResult result = future.get();
            return "Patient added successfully with update time: " + result.getUpdateTime();
        } catch (Exception e) {
            return "Error adding patient data: " + e.getMessage();
        }
    }
}
