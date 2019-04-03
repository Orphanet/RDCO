package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class HasSubtypeListParser {

	private List<SubtypeParser> Subtype;

	
	
	@JsonProperty("Subtype")
	public List<SubtypeParser> getSubtype() {
		return Subtype;
	}

	public void setSubtype(List<SubtypeParser> subtype) {
		Subtype = subtype;
	}
	
	
	
	
	
}
