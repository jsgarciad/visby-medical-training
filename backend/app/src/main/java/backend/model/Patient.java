package backend.model;

import java.util.Map;
import java.util.HashMap;

public class Patient {
    private String id;
    private Map<String, Object> data;

    public Patient() {
        this.data = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void addField(String key, Object value) {
        this.data.put(key, value);
    }
} 