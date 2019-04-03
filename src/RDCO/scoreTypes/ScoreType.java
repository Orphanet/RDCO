package RDCO.scoreTypes;

public abstract class ScoreType {
	protected String label;
	protected String comment;
	protected String baseIri = "http://www.semanticweb.org/RDCO_model_A_oct2018#Score_";
	private boolean declared = false;
	
	
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
	
	public String toOWL(){
		return "";
	}
	
	public String getIri(){
		return baseIri+label.replace(" ", "_");
	}
	
	public String getDeclaration(){
		if(declared){return "";}
		
		declared=true;
		
		return "\n\n    <!-- "+getIri()+" -->\n\n"
			+ "    <owl:Class rdf:about=\""+getIri()+"\">\n"
			+ getAlgorithmCollection()
			+ "        <rdfs:subClassOf rdf:resource=\"http://edamontology.org/data_1772\"/>\n"
			+ "        <rdfs:comment rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">"+getComment()+"</rdfs:comment>\n"
			+ "        <rdfs:label rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">"+getLabel()+"</rdfs:label>\n"
			+ "    </owl:Class>\n\n";
	}
	
	public String getAlgorithmCollection() {
		// TODO Auto-generated method stub
		return null;
	}
}
