package persistence;

import org.json.JSONObject;

// referenced from JsonSerializationDemo
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}