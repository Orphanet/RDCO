package RDCO;

public class Disease extends LinkedConcept{

	Disease(String orphaNum,String label){
		super(orphaNum, label);
		setIdentifier("ORPHA:"+orphaNum);
		setIri("http://www.orpha.net/ORDO/Orphanet_"+orphaNum);		
	}
	
	public String getDeclaration(){
		return "    <!-- "+getIri()+" -->\n\n    <owl:Class rdf:about=\""+getIri()+"\">\n        <rdfs:subClassOf rdf:resource=\"http://www.orpha.net/ORDO/Orphanet_C001#Clinical_Entity\"/>\n        <rdfs:label rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">"+getLabel()+"</rdfs:label>\n        <skos:notation rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">"+getIdentifier()+"</skos:notation>\n    </owl:Class>\n\n";
	}
	
	public String toOWL(){
		return "                <owl:Restriction>\n"
			+ "                    <owl:onProperty rdf:resource=\"http://www.semanticweb.org/RDCO_model_A_oct2018#has_object_clinicalEntity\"/>\n"
			+ "                    <owl:someValuesFrom rdf:resource= \""+getIri()+"\"/>\n"
			+ "                </owl:Restriction>\n";
	}
}
	