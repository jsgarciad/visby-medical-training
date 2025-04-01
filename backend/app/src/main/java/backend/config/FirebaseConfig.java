package backend.config;

import javax.annotation.PostConstruct;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initialize() {
        try {
            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setProjectId("visby-training")
                .build();
            
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public Firestore firestore() {
        return FirestoreClient.getFirestore();
    }
}
