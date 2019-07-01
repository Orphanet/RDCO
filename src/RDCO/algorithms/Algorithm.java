package RDCO.algorithms;

import RDCO.Declaration;
import RDCO.configuration;
import RDCO.scoreTypes.ScoreType;

public abstract class Algorithm {
	protected String label;
	protected String comment;
	protected String baseIri = "http://www.semanticweb.org/RDCO_model_A_oct2018#";
	protected String id;
	protected ScoreType scoreType;
	
	public  ScoreType getScoreType() {
		return scoreType;
	}
	public void setScoreType(ScoreType scoreType) {
		this.scoreType = scoreType;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getBaseIri() {
		return baseIri;
	}
	public void setBaseIri(String baseIri) {
		this.baseIri = baseIri;
	}
	
	public String getIri(){
		return baseIri+label.replace(" ", "_");
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeclaration(){
		
		String declaration = Declaration.Declare(scoreType);
		// Pour Blank Node collection scoretype et modifier la relation ScoreType/Algo 
		//rajouter dans la line declaration une property pour lier au ScoreType (has_score_type) comme Fanny pour trouver la bonne declaration de property (OLS...)
		
		if(configuration.usedAlgorithm(this.label)){
			declaration +="    <!-- "+getIri()+" -->\n\n    <owl:Class rdf:about=\""+getIri()+"\">\n        <rdfs:subClassOf rdf:resource=\"http://semanticscience.org/resource/SIO_000094\"/>\n        <rdfs:comment rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">"+getComment()+"</rdfs:comment>\n        <rdfs:label rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">"+getLabel()+"</rdfs:label>\n    </owl:Class>\n\n"; 
		}
		return declaration;
	}
	
	public String toOWL(){
		if(! configuration.usedAlgorithm(this.label)){
			return "";
		}
		
		/*
		// MODIF FOR D.1.11
		return "    <highlighted_by rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">" + getIri() + "</highlighted_by>\n"
		     + "    <has_score rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">" + scoreType.getIri() + "</has_score>\n";
		
		*/
		
		return "                <owl:Restriction>\n"
			+ "                    <owl:onProperty rdf:resource=\"http://www.semanticweb.org/RDCO_model_A_oct2018#has_score\"/>\n"
			+ "                    <owl:someValuesFrom rdf:resource=\""+scoreType.getIri()+"\"/>\n"
			+ "                </owl:Restriction>\n"
			+ "                <owl:Restriction>\n"
			+ "                    <owl:onProperty rdf:resource=\"http://www.semanticweb.org/RDCO_model_A_oct2018#highlighted_by\"/>\n"
			+ "                    <owl:someValuesFrom rdf:resource=\""+getIri()+"\"/>\n"
			+ "                </owl:Restriction>\n";		
			
	}
	
}
