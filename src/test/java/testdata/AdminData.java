package testdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class AdminData {
    public static AdminData getFiles(String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(fileName), AdminData.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("admin")
    private Admin admin;

    static class Admin {
        @JsonProperty("email")
        private String emailAddress;

        @JsonProperty("password")
        private String password;
    }

    public String getEmailAddress() {
        return admin.emailAddress;
    }

    public String getPassword() {
        return admin.password;
    }


}
