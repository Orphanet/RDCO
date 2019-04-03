package RDCO.algorithms;

import RDCO.scoreTypes.Type3;

public class ResnikSymmetric extends Algorithm{
	
	public ResnikSymmetric(){
		scoreType = new Type3();
		label = "Resnik symmetric";
		id = 8; 
		comment = "The range is 0 to -log(1/number of Diseases in ORDO).It is identify in RDCO as number 8.";
	}
}
