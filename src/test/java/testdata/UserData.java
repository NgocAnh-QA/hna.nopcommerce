package testdata;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserData {
    public static UserData getFiles(String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(fileName), UserData.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

//	static class Register{
//		@JsonProperty("city")
//		private String city;
//	}
//
//	@JsonProperty("register")
//	private Register register;
//
//	public String getCity() {
//		return register.city;
//	}

    @JsonProperty("user_valid")
    private User_valid user_valid;

    static class User_valid {
        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("email")
        private String emailAddress;

        @JsonProperty("password")
        private String password;

        @JsonProperty("confirm_password")
        private String confirmPassword;

        @JsonProperty("company")
        private String companyName;

        @JsonProperty("dateOfBirth")
        private String dateOfBirth;

        @JsonProperty("monthOfBirth")
        private String monthOfBirth;

        @JsonProperty("yearOfYear")
        private String yearOfYear;
    }

    public String getFirstNameValid() {
        return user_valid.firstName;
    }

    public String getLastNameValid() {
        return user_valid.lastName;
    }

    public String getEmailAddressValid() {
        return user_valid.emailAddress;
    }

    public String getPasswordValid() {
        return user_valid.password;
    }

    public String getConfirmPasswordValid() {
        return user_valid.confirmPassword;
    }

    public String getCompanyNameValid() {
        return user_valid.companyName;
    }

    public String getDateOfBirthValid() {
        return user_valid.dateOfBirth;
    }

    public String getMonthOfBirthValid() {
        return user_valid.monthOfBirth;
    }

    public String getYearOfYearValid() {
        return user_valid.yearOfYear;
    }


    /*===========================================*/
    @JsonProperty("user_invalid")
    private User_invalid user_invalid;

    static class User_invalid {
        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("email")
        private String emailAddress;

        @JsonProperty("password")
        private String password;

        @JsonProperty("confirm_password")
        private String confirmPassword;

        @JsonProperty("company")
        private String companyName;

        @JsonProperty("dateOfBirth")
        private String dateOfBirth;

        @JsonProperty("monthOfBirth")
        private String monthOfBirth;

        @JsonProperty("yearOfYear")
        private String yearOfYear;
    }

    public String getFirstNameInvalid() {
        return user_invalid.firstName;
    }

    public String getLastNameInvalid() {
        return user_invalid.lastName;
    }

    public String getEmailAddressInvalid() {
        return user_invalid.emailAddress;
    }

    public String getPasswordInvalid() {
        return user_invalid.password;
    }

    public String getConfirmPasswordInvalid() {
        return user_invalid.confirmPassword;
    }

    public String getCompanyNameInvalid() {
        return user_invalid.companyName;
    }

    public String getDateOfBirthInvalid() {
        return user_invalid.dateOfBirth;
    }

    public String getMonthOfBirthInvalid() {
        return user_invalid.monthOfBirth;
    }

    public String getYearOfYearInvalid() {
        return user_invalid.yearOfYear;
    }

    /*==================================================*/
    @JsonProperty("user_01")
    private User_01 user_01;

    static class User_01 {
        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("email")
        private String emailAddress;

        @JsonProperty("password")
        private String password;

        @JsonProperty("confirm_password")
        private String confirmPassword;

        @JsonProperty("company")
        private String companyName;

        @JsonProperty("dateOfBirth")
        private String dateOfBirth;

        @JsonProperty("monthOfBirth")
        private String monthOfBirth;

        @JsonProperty("yearOfYear")
        private String yearOfYear;
    }
    public String getFirstName_01() {
        return user_01.firstName;
    }
    public String getLastName_01() {
        return user_01.lastName;
    }
    public String getEmailAddress_01() {
        return user_01.emailAddress;
    }
    public String getCompanyName_01() {
        return user_01.companyName;
    }
    public String getPassword_01() {
        return user_01.password;
    }
    public String getConfirmPassword_01() {
        return user_01.confirmPassword;
    }
    public String getDateOfBirth_01() {
        return user_01.dateOfBirth;
    }
    public String getMonthOfBirth_01() {
        return user_01.monthOfBirth;
    }
    public String getYearOfYear_01() {
        return user_01.yearOfYear;
    }
}
