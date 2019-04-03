package RDCO.scoreTypes;

import RDCO.algorithms.ResnikAsymmetric;
import RDCO.algorithms.ResnikSymmetric;

public class Type3 extends ScoreType{
	public Type3(){
		setLabel("Type 3");
		setComment("This score has range 0 and (-log(1/number of Diseases in ORDO)).");
	}
	
	public String getAlgorithmCollection(){
		
		
		ResnikAsymmetric asym = new ResnikAsymmetric();
		ResnikSymmetric  sym  = new ResnikSymmetric();
		return "        <owl:equivalentClass>\n"
			+"            <owl:Class>\n"
			+"                <owl:unionOf rdf:parseType=\"Collection\">\n"
			+"                    <owl:Restriction>\n"
			+"                        <owl:onProperty rdf:resource=\"http://semanticscience.org/resource/SIO_000232\"/>\n"
			+"                        <owl:someValuesFrom rdf:resource=\""+asym.getIri()+"\"/>\n"
			+"                    </owl:Restriction>\n"
			+"                    <owl:Restriction>\n"
			+"                        <owl:onProperty rdf:resource=\"http://semanticscience.org/resource/SIO_000232\"/>\n"
			+"                        <owl:someValuesFrom rdf:resource=\""+sym.getIri()+"\"/>\n"
			+"                    </owl:Restriction>\n"
			+"                </owl:unionOf>\n"
			+"            </owl:Class>\n"
			+"        </owl:equivalentClass>\n";
	}
}
