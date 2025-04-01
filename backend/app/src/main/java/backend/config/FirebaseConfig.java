package backend.config;

import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.PostConstruct;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount = new FileInputStream("/Users/joan.garcia/Documents/visby-medical-training/visby-training-firebase-adminsdk-fbsvc-ba5c5a8cf7.json");

            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://visby-db.firebaseio.com")
                .setProjectId("visby-training")
                .build();
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
