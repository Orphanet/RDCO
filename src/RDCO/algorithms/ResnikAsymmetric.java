package RDCO.algorithms;

import RDCO.scoreTypes.Type1;

public class ResnikAsymmetric extends Algorithm {
	public ResnikAsymmetric(){
		scoreType = new Type1();
		label = "Resnik asymmetric";
		id = "7"; 
		comment = "The range is 0 to -log(1/number of Diseases in ORDO). It is identify in RDCO as number 7.";
	
	}
}
