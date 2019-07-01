package RDCO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RDCOMain {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws IOException {

		// UNIX
		String folder     = "/media/sf_D_DRIVE/Research_Projects/Solve-RD/RDCO/genRDCO/RDCO/inputs/";

		BufferedWriter writer = new BufferedWriter(new FileWriter("/media/sf_D_DRIVE/Research_Projects/Solve-RD/RDCO/genRDCO/RDCO/outputs/RDCO_ORDO_D1.11_collection_STRING.owl"));
		BufferedWriter errors_writer = new BufferedWriter(new FileWriter("/media/sf_D_DRIVE/Research_Projects/Solve-RD/RDCO/genRDCO/RDCO/outputs/errors.txt"));
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader("/media/sf_D_DRIVE/Research_Projects/Solve-RD/RDCO/genRDCO/RDCO/owl_construction/header.txt"));
		  
		
		// add configuration menu
		// gere le menu et donc les choix d'algo et rank 
		configuration.menu();
		
		// get Folders to use with menu
		String[] folders = configuration.getFolders(); 
		File folderTest = new File(folder+folders[0]);
		List< File > listOfFiles = new ArrayList<File> (Arrays.asList(folderTest.listFiles()));
		if(folders.length>1){
			// si on veut les 2 dossiers ORDO et pheno
			folderTest = new File(folder+folders[1]);
			listOfFiles.addAll(Arrays.asList(folderTest.listFiles()));
		}
		
		String header = "";
		String line = null;
		 
		while((line =bufferedReader.readLine())!=null){		 
			header+=line+"\n";
		}
		
		writer.write(header);

	
		int nfile = 0;
		for (File fileJson : listOfFiles) {
			// loop sur les files de results
			nfile += 1;
			if (fileJson.isFile()) {
				
				
				try {
				
					System.out.println("-----> " + fileJson + " - " + nfile);
					
									
					// OLD METHOD FROM SAMUEL 
					// Parse file name to get Phenopacket ID
					/*
					String phenoId="";
					// pour recuper le phenoID dans le nom
					
					Pattern pattern = Pattern.compile("^.*_(S\\d+)[_\\.].*$");
					
					Matcher match   = pattern.matcher(fileJson.getName());
					if(match.matches()){
						phenoId = match.group(1);
						
					}
						*/
					//System.out.println("======> START: " + phenoId + " " + fileJson.getName());
					
					
					String phenoId = fileJson.getName().split("\\.")[0];
					
					
					Phenome subject = new Phenome(phenoId);
					
					//writer.write(">>>"+phenoId+"<<<\n\n");
					
					
					ObjectMapper objectMapper = new ObjectMapper();
					// gere la liste des algo 
					RDCO rdcoObject = objectMapper.readValue(fileJson, RDCO.class);
					rdcoObject.setPhenoPacketId(phenoId);
					
					// transforme les donnees textuelles en classes concepts (disease pheno)
					rdcoObject.instaniateObjects();
					
					//System.out.println(rdcoObject.toString());
					writer.write(Declaration.Declare(subject));
					writer.write(Declaration.Declare(rdcoObject));
					writer.write(rdcoObject.toOWL());
					
				} catch (JsonParseException e) {
			//		System.out.println("---------------------> " + fileJson + " NO ");
					e.printStackTrace();

				} catch (JsonMappingException e) {
					errors_writer.write("--> " + fileJson + "\n");
					errors_writer.flush();
			//		System.out.println("---------------------> " + fileJson + " NO ");
					// e.printStackTrace();

				} catch (IOException e) {
					// System.out.println("---------------------> " + fileJson + " NO ");
					e.printStackTrace();
				}

			}
		}
		writer.write("</rdf:RDF>\n");
		System.out.println("-----> Process finished");
		writer.close();
		errors_writer.close();

	}

}
