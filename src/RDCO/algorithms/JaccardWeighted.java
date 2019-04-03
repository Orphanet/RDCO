package RDCO.algorithms;

import RDCO.scoreTypes.Type1;

public class JaccardWeighted extends Algorithm {
	public JaccardWeighted(){
		scoreType = new Type1();
		label = "Jaccard Weighted";
		id = 5; 
		comment = "The range is 0 and 1. It is identify in RDCO as number 5.";
	}
}
