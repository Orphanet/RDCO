package RDCO.scoreTypes;

import RDCO.algorithms.BernoulliWithGrid;
import RDCO.algorithms.Cosine;
import RDCO.algorithms.CosineWeighted;
import RDCO.algorithms.JaccardSt;
import RDCO.algorithms.JaccardWeighted;

public class Type1 extends ScoreType{
	public Type1(){
		setLabel("Type 1");
		setId("Type_1");
		setComment("This score has range 0 and 1.");
	}
	
	public String getAlgorithmCollection(){
		

		Cosine            cosine = new Cosine();
		CosineWeighted    cosWe  = new CosineWeighted();
		BernoulliWithGrid bernou = new BernoulliWithGrid();
		JaccardSt         jaccSt = new JaccardSt();
		JaccardWeighted   jaccWe = new JaccardWeighted();
		
		return "        <owl:equivalentClass>\n"
			+"            <owl:Class>\n"
			+"                <owl:unionOf rdf:parseType=\"Collection\">\n"
			+"                    <owl:Restriction>\n"
			+"                        <owl:onProperty rdf:resource=\"http://semanticscience.org/resource/SIO_000232\"/>\n"
			+"                        <owl:someValuesFrom rdf:resource=\""+cosine.getIri()+"\"/>\n"
			+"                    </owl:Restriction>\n"
			+"                    <owl:Restriction>\n"
			+"                        <owl:onProperty rdf:resource=\"http://semanticscience.org/resource/SIO_000232\"/>\n"
			+"                        <owl:someValuesFrom rdf:resource=\""+cosWe.getIri()+"\"/>\n"
			+"                    </owl:Restriction>\n"
			+"                    <owl:Restriction>\n"
			+"                        <owl:onProperty rdf:resource=\"http://semanticscience.org/resource/SIO_000232\"/>\n"
			+"                        <owl:someValuesFrom rdf:resource=\""+bernou.getIri()+"\"/>\n"
			+"                    </owl:Restriction>\n"
			+"                    <owl:Restriction>\n"
			+"                        <owl:onProperty rdf:resource=\"http://semanticscience.org/resource/SIO_000232\"/>\n"
			+"                        <owl:someValuesFrom rdf:resource=\""+jaccSt.getIri()+"\"/>\n"
			+"                    </owl:Restriction>\n"
			+"                    <owl:Restriction>\n"
			+"                        <owl:onProperty rdf:resource=\"http://semanticscience.org/resource/SIO_000232\"/>\n"
			+"                        <owl:someValuesFrom rdf:resource=\""+jaccWe.getIri()+"\"/>\n"
			+"                    </owl:Restriction>\n"
			+"                </owl:unionOf>\n"
			+"            </owl:Class>\n"
			+"        </owl:equivalentClass>\n";
	}
}
