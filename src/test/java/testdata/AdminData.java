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

    /* ADMIN 02*/
    @JsonProperty("admin_02")
    private AdminData.Admin_02 admin_02;

    static class Admin_02 {
        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String last_name;

        @JsonProperty("email")
        private String email;

        @JsonProperty("password")
        private String password;

        @JsonProperty("confirm_password")
        private String confirm_password;

        @JsonProperty("company_name")
        private String company_name;

        @JsonProperty("customer_roles")
        private String customer_roles;

        @JsonProperty("date_of_birth")
        private String date_of_birth;

        @JsonProperty("admin_comment")
        private String admin_comment;

        @JsonProperty("country")
        private String country;

        @JsonProperty("state_province")
        private String state_province;

        @JsonProperty("city")
        private String city;

        @JsonProperty("address1")
        private String address1;

        @JsonProperty("address2")
        private String address2;

        @JsonProperty("zip_postal")
        private String zip_postal;

        @JsonProperty("phone_number")
        private String phone_number;

        @JsonProperty("fax_number")
        private String fax_number;
    }

    public String getFirstName_02() {
        return admin_02.firstName;
    }
    public String getLastName_02() {
        return admin_02.last_name;
    }
    public String getEmail_02() {
        return admin_02.email;
    }
    public String getPassword_02() {
        return admin_02.password;
    }
    public String getConfirmPassword_02() {
        return admin_02.confirm_password;
    }
    public String getCompanyName_02() {
        return admin_02.company_name;
    }
    public String getCustomerRoles_02() {
        return admin_02.customer_roles;
    }
    public String getDateOfBirth_02() {
        return admin_02.date_of_birth;
    }
    public String getAdminComment_02() {
        return admin_02.admin_comment;
    }
    public String getCountry_02() {
        return admin_02.country;
    }
    public String getStateProvince_02() {
        return admin_02.state_province;
    }
    public String getCity_02() {
        return admin_02.city;
    }
    public String getAddress1_02() {
        return admin_02.address1;
    }
    public String getAddress2_02() {
        return admin_02.address2;
    }
    public String getZipPostal_02() {
        return admin_02.zip_postal;
    }
    public String getPhoneNumber_02() {
        return admin_02.phone_number;
    }
    public String getFaxNumber_02() {
        return admin_02.fax_number;
    }


}
