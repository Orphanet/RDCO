package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties(ignoreUnknown=true)
public class SubClassOfListParser {
	
	
	private List<DisorderParser> Disorder;


	@JsonProperty("Disorder")
	public List<DisorderParser> getDisorder() {
		return Disorder;
	}

	public void setDisorder(List<DisorderParser> disorder) {
		Disorder = disorder;
	}
	

}
