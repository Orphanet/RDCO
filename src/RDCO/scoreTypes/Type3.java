package RDCO.scoreTypes;

import java.util.ArrayList;

import RDCO.configuration;
import RDCO.algorithms.Algorithm;
import RDCO.algorithms.Phenodigm;
import RDCO.algorithms.ResnikAsymmetric;
import RDCO.algorithms.ResnikSymmetric;

public class Type3 extends ScoreType{
	public Type3(){
		setLabel("Type 3");
		setId("Type_3");
		setComment("This score has range 0 and (-log(1/number of Diseases in ORDO)).");
	}
	
	public String getAlgorithmCollection(){
		
		ArrayList<Algorithm> algos = new ArrayList<Algorithm>();
		if(configuration.usedAlgorithm("Resnik symmetric")){
			algos.add( new ResnikSymmetric());
		}
		if(configuration.usedAlgorithm("Resnik asymmetric")){
			algos.add( new ResnikAsymmetric());
		}
		
		/// use this if you want to abort Type3 declaration if no Type 3 algo is declared
		/*if(algos.size() ==0){
			return "";
		}*/
		
		String declar = "        <owl:equivalentClass>\n"
						+"            <owl:Class>\n"
						+"                <owl:unionOf rdf:parseType=\"Collection\">\n";
		
		 for(Algorithm algo : algos){
			 declar += "                    <owl:Restriction>\n"
					+"                        <owl:onProperty rdf:resource=\"http://semanticscience.org/resource/SIO_000232\"/>\n"
					+"                        <owl:someValuesFrom rdf:resource=\""+algo.getIri()+"\"/>\n"
					+"                    </owl:Restriction>\n";
		 }
		declar += "                </owl:unionOf>\n"
				+"            </owl:Class>\n"
				+"        </owl:equivalentClass>\n";
		return declar;
	}
}
