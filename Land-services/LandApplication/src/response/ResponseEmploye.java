package response;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class ResponseEmploye {
    private String name;
    private int status;
    
    public ResponseEmploye() {
    }

    @JsonbCreator
    public ResponseEmploye(@JsonbProperty("name") String name, @JsonbProperty("status") int status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }
}
