package RDCO.algorithms;

import RDCO.scoreTypes.Type1;

public class JaccardSt extends Algorithm {
	public JaccardSt(){
		scoreType = new Type1();
		label = "Jaccard St";
		id = 4; 
		comment = "The range is 0 and 1. It is identify in RDCO as number 4.";
	}
}
