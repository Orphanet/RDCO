package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ExternalReferenceListParser {

	
	private List<ExternalReferenceParser> ExternalReference;
	private String count;
	

	
	@JsonProperty("ExternalReference")
	public List<ExternalReferenceParser> getExternalReference() {
		return ExternalReference;
	}

	public void setExternalReference(List<ExternalReferenceParser> externalReference) {
		ExternalReference = externalReference;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	
	
	
	
	
	
	
	
}
