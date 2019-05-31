package RDCO.scoreTypes;

import java.util.ArrayList;

import RDCO.configuration;
import RDCO.algorithms.*;

public class Type1 extends ScoreType{
	public Type1(){
		setLabel("Type 1");
		setId("Type_1");
		setComment("This score has range 0 and 1.");
	}
	
	
	
	// Pour Blank Node collection scoretype et modifier la relation ScoreType/Algo 
	//supprimer ici getAlgorithmCollection()

	
	
	public String getAlgorithmCollection(){
		
		ArrayList<Algorithm> algos = new ArrayList<Algorithm>();
		if(configuration.usedAlgorithm("Cosine")){
			algos.add( new Cosine());
		}
		if(configuration.usedAlgorithm("Cosine Weighted")){
			algos.add( new CosineWeighted());
		}
		if(configuration.usedAlgorithm("Bernoulli with grid")){
			algos.add( new BernoulliWithGrid());
		}
		if(configuration.usedAlgorithm("Jaccard St")){
			algos.add( new JaccardSt());
		}
		if(configuration.usedAlgorithm("Jaccard Weighted")){
			algos.add( new JaccardWeighted());
		}
		
		/// use this if you want to abort Type2 declaration if no Type 2 algo is declared
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
	
	// Fin de suppress 


	
}
