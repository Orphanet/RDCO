package RDCO.scoreTypes;

import RDCO.algorithms.Phenodigm;

public class Type2 extends ScoreType{
	public Type2(){
		setLabel("Type 2");
		setId("Type_2");
		setComment("This score has range 0 and 100.");
	}
	
	public String getAlgorithmCollection(){
		
		
		Phenodigm pheno = new Phenodigm();
		return "        <owl:equivalentClass>\n"
			+"            <owl:Class>\n"
			+"                <owl:unionOf rdf:parseType=\"Collection\">\n"
			+"                    <owl:Restriction>\n"
			+"                        <owl:onProperty rdf:resource=\"http://semanticscience.org/resource/SIO_000232\"/>\n"
			+"                        <owl:someValuesFrom rdf:resource=\""+pheno.getIri()+"\"/>\n"
			+"                    </owl:Restriction>\n"
			+"                </owl:unionOf>\n"
			+"            </owl:Class>\n"
			+"        </owl:equivalentClass>\n";
	}
}
