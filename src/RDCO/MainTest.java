package RDCO;

import RDCO.algorithms.*;
import RDCO.scoreTypes.*;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Algorithm test = new ResnikSymmetric();
		System.out.println(test.getDeclaration());
		

		test = new ResnikAsymmetric();
		System.out.println(test.getDeclaration());

		test = new Cosine();
		System.out.println(test.getDeclaration());

		test = new CosineWeighted();
		System.out.println(test.getDeclaration());
		
		
		test = new BernoulliWithGrid();
		System.out.println(test.getDeclaration());
		
		
		test = new JaccardWeighted();
		System.out.println(test.getDeclaration());
		
		test = new JaccardSt();
		System.out.println(test.getDeclaration());
		
		test = new Phenodigm();
		System.out.println(test.getDeclaration());
		
		ScoreType testType = new Type3();
		System.out.println(testType.getDeclaration());
	}

}
