package RDCO;

import java.util.regex.*;

import RDCO.algorithms.Algorithm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResultParser {
	private String itemId;
	private float score;
	private String itemName;
	private float rank;
	private MethodParser methodParent;
	private LinkedConcept concept;
	
	@JsonProperty("itemid")
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	@JsonProperty("score")
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	@JsonProperty("itemname")
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	@JsonProperty("rank")
	public float getRank() {
		return rank;
	}
	public void setRank(float rank) {
		this.rank = rank;
	}
	
	public void setMethodParent(MethodParser parent){
		methodParent = parent;
	}
	public MethodParser getMethodParent(){
		return methodParent;
	}
	
	public String getPhenoId(){
		return methodParent.getPhenoId();
	}
		public LinkedConcept getConcept() {
		return concept;
	}
	public void setConcept(LinkedConcept concept) {
		this.concept = concept;
	}
	
	public String toString(){
		//return itemId+"   "+itemName+" => "+score;
		return toOWL();
	}
	
	public void instantiateLinkedConcept(){
		
		if(!configuration.overMaxRank(this.rank)){
		
			Pattern patternOrpha = Pattern.compile("^ORPHA:(\\d+)$"); 
			Matcher matchOrpha   = patternOrpha.matcher(itemId);
			
			if(matchOrpha.matches()){
				//System.out.println("-----ORPHA> "  + itemId);
				setConcept(new Disease(matchOrpha.group(1),itemName));
			}else{
			//	System.out.println("-----> "  + itemId);
				//Pattern patternPheno  = Pattern.compile("^.*_(S\\d+)_.*$"); 
				Pattern patternPheno  = Pattern.compile("^.*(S\\d+).*$");  // Problem with "_" in IDs fixed 
				Matcher matchPheno    = patternPheno.matcher(itemId);
				if(matchPheno.matches()){
	
					setConcept(new Phenome(matchPheno.group(1)));
					
				}else{
					System.out.println("ERROR itemId : "+itemId);
				}
			}
		}
	}
	
	public String toOWL(){
		
		//return getPhenoId()+concept.toOWL();
		if(configuration.overMaxRank(this.rank)){return "";}
		
		String typeOfAsso = "";
		if(concept.getClass().equals(Disease.class)){
			typeOfAsso = "    <rdfs:subClassOf rdf:resource=\"http://www.semanticweb.org/RDCO_model_A_oct2018#Association_Case-ClinicalEntity\"/>";
		}else{
			typeOfAsso = "        <rdfs:subClassOf rdf:resource=\"http://www.semanticweb.org/RDCO_model_A_oct2018#Association_Case-Case\"/>";
		}
		Algorithm algo = methodParent.getAlgo();
		
		//
		Float score = getScore();
		//

		return "<!-- "+methodParent.getRDCOParent().getBaseIri() +concept.getIdentifier()+"_PhenoP:"+getPhenoId()+"_Algo:"+algo.getId()+" -->\n\n"
				+"<owl:Class rdf:about=\""+methodParent.getRDCOParent().getBaseIri() +concept.getIdentifier()+"_PhenoP:"+getPhenoId()+"_Algo:"+algo.getId()+"\">\n"
				+ "    <owl:equivalentClass>\n"
				+ "        <owl:Class>\n"
				+ "            <owl:intersectionOf rdf:parseType=\"Collection\">\n"
				+ "                <owl:Restriction>\n"
				+ "                    <owl:onProperty rdf:resource=\"http://www.semanticweb.org/RDCO_model_A_oct2018#association_has_subject\"/>\n"
				+ "                    <owl:someValuesFrom rdf:resource=\""+methodParent.getRDCOParent().getBaseIri() +"Phenopacket_"+getPhenoId()+"\"/>\n"
				+ "                </owl:Restriction>\n"
				+ concept.toOWL()
				+ "                <owl:Restriction>\n"
				+ "                    <owl:onProperty rdf:resource=\"http://www.semanticweb.org/RDCO_model_A_oct2018#has_similarity_level\"/>\n"
				+ "                    <owl:someValuesFrom rdf:resource=\"http://purl.obolibrary.org/obo/HOM_0000000\"/>\n"
				+ "                </owl:Restriction>\n"
				+ algo.toOWL()
				+ "                <owl:Restriction>\n"
				+ "                    <owl:onProperty rdf:resource=\"http://www.semanticweb.org/RDCO_model_A_oct2018#has_score_value\"/>\n"
		//		+ "                    <owl:hasValue rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">"+getScore()+"</owl:hasValue>\n"		 // TEST TO CHANGE VALUE FLOAT TO  STRING		
				+ "                    <owl:hasValue rdf:datatype=\"http://www.w3.org/2001/XMLSchema#float\">"+getScore()+"</owl:hasValue>\n"
				+ "                </owl:Restriction>\n"
				+ "            </owl:intersectionOf>\n"
				+ "        </owl:Class>\n"
				+ "    </owl:equivalentClass>\n"
				+ typeOfAsso+"\n"
				
				+ "    <rdfs:label rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">"+concept.getIdentifier()+"_PhenoP:"+getPhenoId()+"_Algo:"+algo.getId()+"</rdfs:label>\n"
			
				/*
				// ADD TO FIX 
				+ "    <association_has_subject rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">"+methodParent.getRDCOParent().getBaseIri() +"Phenopacket_"+getPhenoId()+"</association_has_subject>\n"
				+ concept.toOWL()
				+ "    <has_similarity_level rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">HOM_0000000</has_similarity_level>\n"
				+ algo.toOWL()
				+ "    <has_value rdf:datatype=\"http://www.w3.org/2001/XMLSchema#float\">"+score+"</has_value>\n"
				//has_value NOT has_score_value !!!
				*/
				
				
				+ "</owl:Class>\n\n";
		
		
	}

	public String getDeclaration(){	
		if(configuration.overMaxRank(this.rank)){return "";}
		return Declaration.Declare(concept);
	}
}
