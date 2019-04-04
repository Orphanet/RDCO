package RDCO.algorithms;

import RDCO.scoreTypes.Type1;

public class BernoulliWithGrid extends Algorithm {
	public BernoulliWithGrid(){
		scoreType = new Type1();
		label = "Bernoulli with grid";
		id = "1"; 
		comment = "The range is 0 and 100. It is identify in RDCO as number 1.";
	}
}
