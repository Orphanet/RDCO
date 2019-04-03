package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GeneParser {

	private List<NameParser> Name;
	private List<ExternalReferenceListParser> ExternalReferenceList;
	private String Symbol;
	
	
	
	@JsonProperty("Name")
	public List<NameParser> getName() {
		return Name;
	}
	public void setName(List<NameParser> name) {
		Name = name;
	}
	
	@JsonProperty("ExternalReferenceList")
	public List<ExternalReferenceListParser> getExternalReferenceList() {
		return ExternalReferenceList;
	}
	public void setExternalReferenceList(List<ExternalReferenceListParser> externalReferenceList) {
		ExternalReferenceList = externalReferenceList;
	}
	
	@JsonProperty("Symbol")
	public String getSymbol() {
		return Symbol;
	}
	public void setSymbol(String symbol) {
		Symbol = symbol;
	}
	
	
	
	
	
	
	
	
	
	
}
