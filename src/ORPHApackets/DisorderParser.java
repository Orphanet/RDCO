package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties(ignoreUnknown=true)
public class DisorderParser {
	
	
	private List<NameParser> Name;
	private List<DisorderGeneAssociationParser> DisorderGeneAssociation;
	private String ORPHA;
	private String PURL;
	
	
	
	@JsonProperty("DisorderGeneAssociation")
	public List<DisorderGeneAssociationParser> getDisorderGeneAssociation() {
		return DisorderGeneAssociation;
	}
	public void setDisorderGeneAssociation(List<DisorderGeneAssociationParser> disorderGeneAssociation) {
		DisorderGeneAssociation = disorderGeneAssociation;
	}
	@JsonProperty("Name")
	public List<NameParser> getName() {
		return Name;
	}
	public void setName(List<NameParser> name) {
		Name = name;
	}
	
	@JsonProperty("ORPHA")
	public String getORPHA() {
		return ORPHA;
	}
	public void setORPHA(String oRPHA) {
		ORPHA = oRPHA;
	}
	
	@JsonProperty("PURL")
	public String getPURL() {
		return PURL;
	}
	public void setPURL(String pURL) {
		PURL = pURL;
	}
	

}
