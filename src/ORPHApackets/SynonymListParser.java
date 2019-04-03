package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class SynonymListParser {
	
	private List<NameParser> Synonym;
	private String count;
	
	
	
	
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@JsonProperty("Synonym")
	public List<NameParser> getSynonym() {
		return Synonym;
	}

	public void setSynonym(List<NameParser> synonym) {
		Synonym = synonym;
	}
	
	
	
	

}
