package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DisorderMappingRelationParser {
	
	
	private List<NameParser> DisorderMappingRelationName;
	private String DisorderMappingRelationId;
	
	
	@JsonProperty("Name")
	public List<NameParser> getDisorderMappingRelationName() {
		return DisorderMappingRelationName;
	}
	public void setDisorderMappingRelationName(List<NameParser> disorderMappingRelationName) {
		DisorderMappingRelationName = disorderMappingRelationName;
	}
	
	@JsonProperty("id")
	public String getDisorderMappingRelationId() {
		return DisorderMappingRelationId;
	}
	public void setDisorderMappingRelationId(String disorderMappingRelationId) {
		DisorderMappingRelationId = disorderMappingRelationId;
	}
	
	
	

}
