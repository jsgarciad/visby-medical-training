package backend.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import com.google.cloud.firestore.WriteResult;

@Service
public class PatientService {
    private final Firestore firestore;

    public PatientService() {
        this.firestore = FirestoreClient.getFirestore();
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
            // Add a new patient document
            ApiFuture<WriteResult> future = firestore.collection("patients").document().set(patientData);
            WriteResult result = future.get();

            return "Patient added with id: " + result.getUpdateTime();
        } catch (Exception e) {
            return "Error adding patient data: " + e.getMessage();
        }
    }
}
