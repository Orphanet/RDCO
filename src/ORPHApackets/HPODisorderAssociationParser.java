package ORPHApackets;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class HPODisorderAssociationParser {

	
	private List<Name> HPOFrequency;
	private String HPOId;
	private String HPOTerm;
	private String PURL;
	

	@JsonProperty("HPOFrequency")
	public List<Name> getHPOFrequency() {
		return HPOFrequency;
	}

	public void setHPOFrequency(List<Name> hPOFrequency) {
		HPOFrequency = hPOFrequency;
	}

	@JsonProperty("HPOId")
	public String getHPOId() {
		return HPOId;
	}

	public void setHPOId(String hPOId) {
		HPOId = hPOId;
	}
	
	@JsonProperty("HPOTerm")
	public String getHPOTerm() {
		return HPOTerm;
	}
	public void setHPOTerm(String hPOTerm) {
		HPOTerm = hPOTerm;
	}
	
	@JsonProperty("PURL")
	public String getPURL() {
		return PURL;
	}
	public void setPURL(String pURL) {
		PURL = pURL;
	}
	
	
}
