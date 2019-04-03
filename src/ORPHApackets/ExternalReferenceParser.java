package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class ExternalReferenceParser {
	
	private List<DisorderMappingRelationParser> DisorderMappingRelation;
	private String Reference;
	private String Source;
	

	
	@JsonProperty("DisorderMappingRelation")
	public List<DisorderMappingRelationParser> getDisorderMappingRelation() {
		return DisorderMappingRelation;
	}

	public void setDisorderMappingRelation(List<DisorderMappingRelationParser> disorderMappingRelation) {
		DisorderMappingRelation = disorderMappingRelation;
	}

	
	@JsonProperty("Reference")
	public String getReference() {
		return Reference;
	}

	public void setReference(String reference) {
		Reference = reference;
	}

	
	
	@JsonProperty("Source")
	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}
	
	

}
