package RDCO;

public class Phenome extends LinkedConcept{

	Phenome(String id){
		super();
		setIri("http://www.semanticweb.org/RDCO_model_A_oct2018#Phenopacket_"+id);
		setLabel("Phenopacket "+id);
		setId(id);
		setIdentifier("PhenoP:"+id);
	}
	
	public String getDeclaration(){
		return "<!-- "+getIri()+" -->\n\n<owl:Class rdf:about=\""+getIri()+"\">\n    <rdfs:subClassOf rdf:resource=\"http://www.semanticweb.org/RDCO_model_A_oct2018#Case\"/>\n    <terms:identifier rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">"+getId()+"</terms:identifier>\n    <rdfs:label rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">"+getLabel()+"</rdfs:label>\n</owl:Class>\n\n";
	}
	
	public String toOWL(){
		return "                    <owl:Restriction>\n"
			+ "                        <owl:onProperty rdf:resource=\"http://www.semanticweb.org/RDCO_model_A_oct2018#has_object_case\"/>\n"
			+ "                        <owl:someValuesFrom rdf:resource=\""+getIri()+"\"/>\n"
			+ "                    </owl:Restriction>\n";
	}
}

