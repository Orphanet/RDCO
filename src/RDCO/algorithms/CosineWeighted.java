package RDCO.algorithms;

import RDCO.scoreTypes.Type1;

public class CosineWeighted extends Algorithm {
	public CosineWeighted(){
		scoreType = new Type1();
		label = "Cosine Weighted";
		id = "3"; 
		comment = "The range is 0 and 1. It is identify in RDCO as number 3.";
	}
}
