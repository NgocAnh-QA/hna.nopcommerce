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

	@JsonProperty("firstname")
	private String firstName;

	@JsonProperty("lastname")
	private String lastName;

	@JsonProperty("email")
	private String emailAddress;

	@JsonProperty("password")
	private String password;

	@JsonProperty("company")
	private String companyName;

	@JsonProperty("dateOfBirth")
	private String dateOfBirth;

	@JsonProperty("monthOfBirth")
	private String monthOfBirth;

	@JsonProperty("yearOfYear")
	private String yearOfYear;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
 
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getMonthOfBirth() {
		return monthOfBirth;
	}

	public String getYearOfYear() {
		return yearOfYear;
	}

	static class Register{
		@JsonProperty("city")
		private String city;
	}
	
	@JsonProperty("register")
	private Register register;
	
	public String getCity() {
		return register.city;
	}
}
