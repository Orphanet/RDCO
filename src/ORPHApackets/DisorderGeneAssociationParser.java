package ORPHApackets;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DisorderGeneAssociationParser {
	
	
	private List<DisorderGeneAssociationTypeParser> DisorderGeneAssociationType;
	private List<GeneParser> Gene;
	
	
	@JsonProperty("DisorderGeneAssociationType")
	public List<DisorderGeneAssociationTypeParser> getDisorderGeneAssociationType() {
		return DisorderGeneAssociationType;
	}
	public void setDisorderGeneAssociationType(List<DisorderGeneAssociationTypeParser> disorderGeneAssociationType) {
		DisorderGeneAssociationType = disorderGeneAssociationType;
	}
	
	@JsonProperty("Gene")
	public List<GeneParser> getGene() {
		return Gene;
	}
	public void setGene(List<GeneParser> gene) {
		Gene = gene;
	}
	
	
	
	
	
	
	
	

}
