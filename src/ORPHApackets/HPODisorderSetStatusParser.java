package ORPHApackets;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class HPODisorderSetStatusParser {

	private String ValidationStatus;

	
	@JsonProperty("ValidationStatus")
	public String getValidationStatus() {
		return ValidationStatus;
	}

	public void setValidationStatus(String validationStatus) {
		ValidationStatus = validationStatus;
	}
	
	
	
	
	
}
