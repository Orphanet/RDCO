package RDCO.algorithms;

import RDCO.scoreTypes.Type1;

public class Cosine extends Algorithm {
	public Cosine(){
		scoreType = new Type1();
		label = "Cosine";
		id = "2"; 
		comment = "The range is 0 and 1. It is identify in RDCO as number 2.";
	}
}
