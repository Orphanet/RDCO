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
		File folderOrdo = new File("C:\\Users\\sdemarest.BROUSSAIS\\gitLuna\\genRDCO\\inputs\\ORDO\\");
		File folderPheno = new File("C:\\Users\\sdemarest.BROUSSAIS\\gitLuna\\genRDCO\\inputs\\pheno\\");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\sdemarest.BROUSSAIS\\gitLuna\\genRDCO\\outputs\\RDCO.owl"));
		BufferedWriter errors_writer = new BufferedWriter(new FileWriter("C:\\Users\\sdemarest.BROUSSAIS\\gitLuna\\genRDCO\\outputs\\errors.txt"));
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\sdemarest.BROUSSAIS\\gitLuna\\genRDCO\\owl_construction\\header.txt"));
		  
		String header = "";
		String line = null;
		 
		while((line =bufferedReader.readLine())!=null){		 
			header+=line+"\n";
		}
		
		writer.write(header);

		//File[] listOfFiles = folderOrdo.listFiles();
		List< File > listOfFiles = new ArrayList<File> (Arrays.asList(folderOrdo.listFiles()));
		listOfFiles.addAll(Arrays.asList(folderPheno.listFiles()));
		
	
		int nfile = 0;
		for (File fileJson : listOfFiles) {
			nfile += 1;
			if (fileJson.isFile()) {
				
				
				try {
				
					System.out.println("-----> " + fileJson + " - " + nfile);
					
									
					// Parse file name to get Phenopacket ID
					String phenoId="";
					Pattern pattern = Pattern.compile("^.*_(S\\d+)[_\\.].*$");
					Matcher match   = pattern.matcher(fileJson.getName());
					if(match.matches()){
						phenoId = match.group(1);
					}
					
					Phenome subject = new Phenome(phenoId);
					
					//writer.write(">>>"+phenoId+"<<<\n\n");
					
					
					ObjectMapper objectMapper = new ObjectMapper();
					RDCO rdcoObject = objectMapper.readValue(fileJson, RDCO.class);
					rdcoObject.setPhenoPacketId(phenoId);
					
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
