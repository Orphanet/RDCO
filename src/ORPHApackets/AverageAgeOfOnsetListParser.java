package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AverageAgeOfOnsetListParser {
	
	private List<AverageAgeOfOnsetParser> AverageAgeOfOnset;

	
	@JsonProperty("AverageAgeOfOnset")
	public List<AverageAgeOfOnsetParser> getAverageAgeOfOnset() {
		return AverageAgeOfOnset;
	}

	public void setAverageAgeOfOnset(List<AverageAgeOfOnsetParser> averageAgeOfOnset) {
		AverageAgeOfOnset = averageAgeOfOnset;
	}
	
	    

}
