package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DisorderGeneAssociationTypeParser {
	
	
	private String OrphaNumber;
	private List<NameParser> Name;
	
	
	
	@JsonProperty("Name")
	public List<NameParser> getName() {
		return Name;
	}
	public void setName(List<NameParser> name) {
		Name = name;
	}
	
	@JsonProperty("OrphaNumber")
	public String getOrphaNumber() {
		return OrphaNumber;
	}
	public void setOrphaNumber(String orphaNumber) {
		OrphaNumber = orphaNumber;
	}
	
	
	
	
	

}
