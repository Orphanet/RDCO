package RDCO;

import java.util.HashMap;
import java.util.Scanner;

import RDCO.algorithms.*;

public class configuration {
	private static String[] folders;
	private static Float maxRank;
	
	@SuppressWarnings("serial")
	private static HashMap<String,Boolean> algorithms = new HashMap<String,Boolean>(){{
		put("Resnik symmetric",true);
		put("Resnik asymmetric",true);
		put("Phenodigm",true);
		put("Jaccard Weighted",true);
		put("Jaccard St",true);
		put("Cosine Weighted",true);
		put( "Cosine",true);
		put("Bernoulli with grid",true);
	}};

	public static String[] getFolders() {
		return folders;
	}

	public void setFolders(String[] folders) {
		configuration.folders = folders;
	}
	
	@SuppressWarnings("resource")
	public static void menu(){
		Scanner input = new Scanner(System.in);
		System.out.println("Wich data would you use ?");
		System.out.println("\t1 : ORDO\n\t2 : Pheno\n\t3 : both");
		int selection = input.nextInt();
		
		switch (selection){
			case 1:
				folders = new String[1];
				folders[0]="ORDO";
				break;
			case 2:
				folders = new String[1];
				folders[0]="pheno";
				break;
			default:
				folders = new String[2];
				folders[0]="ORDO";
				folders[1]="pheno";
		}
		
		System.out.println("Indicate a max rank : ");
		maxRank = (float) input.nextInt();
		
		System.out.println("Wich algorithms would you exclude (if you want to exclude multiple algorithms, use ',' to seperate each number) ?");
		System.out.println("\t1 : Bernoulli with grid\n\t2 : Cosine\n\t3 : Cosine Weighted\n\t4 : Jaccard St\n\t5 : Jaccard Weighted\n\t6 : Phenodigm\n\t7 : Resnik asymmetric\n\t8 : Resnik symmetric\n\t9 : none");
		input.nextLine();
		String list = input.nextLine();
		String[] algos = list.split(",");
		for(String algo : algos){
			switch (algo){
				case "1":
					algorithms.put("Bernoulli with grid",false);
					break;
				case "2":
					algorithms.put("Cosine",false);
					break;
				case "3":
					algorithms.put("Cosine Weighted",false);
					break;
				case "4":
					algorithms.put("Jaccard St",false);
					break;
				case "5":
					algorithms.put("Jaccard Weighted",false);
					break;
				case "6":
					algorithms.put("Phenodigm",false);
					break;
				case "7":
					algorithms.put("Resnik asymmetric",false);
					break;
				case "8":
					algorithms.put("Resnik symmetric",false);
					break;
				default:
			}
		}
		
	}

	public static boolean overMaxRank(float rank) {
		// TODO Auto-generated method stub
		return rank > maxRank;
	}

	public HashMap<String, Boolean> getAlgorithms() {
		return algorithms;
	}

	public void setAlgorithms(HashMap<String,Boolean> algorithms) {
		configuration.algorithms = algorithms;
	}
	
	public static boolean usedAlgorithm(String algoLab){
		return algorithms.get(algoLab);
	}
}
