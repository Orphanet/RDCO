package ORPHApackets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ORPHApacketMain {

	public static void main(String[] args) throws IOException {

		// UNIX
		File folder = new File("/media/sf_D_DRIVE/Dev/ELK/files/test/");
		//File folder = new File("/media/sf_D_DRIVE/Dev/ELK/files/json_files/");
		//File folder = new File("/media/sf_D_DRIVE/Dev/ELK/files/errors/");
		//File folder = new File("/media/sf_D_DRIVE/Dev/ELK/files/onefile/");
		BufferedWriter writer = new BufferedWriter(new FileWriter("/media/sf_D_DRIVE/Dev/ELK/files/elastic.json"));
		BufferedWriter errors_writer = new BufferedWriter(new FileWriter("/media/sf_D_DRIVE/Dev/ELK/files/errors.txt"));

		// OSX
		//File folder = new File("/Users/davidlagorce/Work/ELK/test/");
		//File folder = new File("/Users/davidlagorce/Work/ELK/json_files/");
		//BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/davidlagorce/Work/ELK/elastic.json"));
		//BufferedWriter errors_writer = new BufferedWriter(new FileWriter("/Users/davidlagorce/Work/ELK/errors.txt"));

		File[] listOfFiles = folder.listFiles();

		int nfile = 0;
		for (File fileJson : listOfFiles) {
			nfile += 1;
			if (fileJson.isFile()) {
				
				
				try {
				
					if (nfile < 55) {
						System.out.println("-----> " + fileJson + " - " + nfile);
					}
					

					ObjectMapper objectMapper = new ObjectMapper();
					ORPHApacket orphapacket = objectMapper.readValue(fileJson, ORPHApacket.class);
					
					
					
					//ORIGINAL
					//ORPHApacketService service = new ORPHApacketService();
					//service.execute(orphapacket, writer);

					//ELK NESTED
					ORPHApacketServiceELKNested servicenested = new ORPHApacketServiceELKNested ();
					servicenested.execute(orphapacket, writer);
				
					
					
					
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
		System.out.println("-----> Process finished");
		writer.close();
		errors_writer.close();

	}

}
