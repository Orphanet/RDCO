package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class HPODisorderAssociationListParser {
	
	private List<HPODisorderAssociationParser> HPODisorderAssociation;
	
	@JsonProperty("HPODisorderAssociation")
	public List<HPODisorderAssociationParser> getHPODisorderAssociation() {
		return HPODisorderAssociation;
	}

	public void setHPODisorderAssociation(List<HPODisorderAssociationParser> hPODisorderAssociation) {
		HPODisorderAssociation = hPODisorderAssociation;
	}



}
