package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Disorder {
	
	private List<Name> Disorder;
	private String ORPHA;
	private String PURL;
	
	
	
	@JsonProperty("Disorder")
	public List<Name> getDisorder() {
		return Disorder;
	}
	public void setDisorder(List<Name> disorder) {
		Disorder = disorder;
	}
	
	@JsonProperty("ORPHA")
	public String getORPHA() {
		return ORPHA;
	}
	public void setORPHA(String oRPHA) {
		ORPHA = oRPHA;
		
	}
	
	@JsonProperty("PURL")
	public String getPURL() {
		return PURL;
	}
	public void setPURL(String pURL) {
		PURL = pURL;
	}


	
	
	
	
	
	
}


