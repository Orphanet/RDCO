package ORPHApackets;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisorderGeneAssociationListParser {

	private List<DisorderGeneAssociationParser> DisorderGeneAssociation;
	private String count;
	
	
	@JsonProperty("DisorderGeneAssociation")
	public List<DisorderGeneAssociationParser> getDisorderGeneAssociation() {
		return DisorderGeneAssociation;
	}

	public void setDisorderGeneAssociation(List<DisorderGeneAssociationParser> disorderGeneAssociation) {
		DisorderGeneAssociation = disorderGeneAssociation;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	
	
	
}
