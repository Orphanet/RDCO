package ORPHApackets;

import java.io.BufferedWriter;
import java.io.IOException;

public class ORPHApacketService {

	public void execute(ORPHApacket orphapacket, BufferedWriter writer) throws IOException {

		writer.write("{\"index\": {}}\n");

		String elasticLine = "{";
		//elasticLine += "{ \"Version\" : \"" + orphapacket.getORPHApacket().get(0).getVersion() + "\" , ";
		//elasticLine += "\"Copyright\" : \"" + orphapacket.getORPHApacket().get(0).getCopyright() + "\" , ";
		//elasticLine += "\"Date\" : \"" + orphapacket.getORPHApacket().get(0).getDate() + "\" , ";
		elasticLine += "\"Disorder Name\" : \"" + orphapacket.getORPHApacket().get(0).getName().get(0).getLabel()
				+ "\" , ";
		elasticLine += "\"ORPHA\" :\"" + orphapacket.getORPHApacket().get(0).getORPHA() + "\" , ";
		elasticLine += "\"PURL\" :\"" + orphapacket.getORPHApacket().get(0).getPURL() + "\" , ";
		elasticLine += "\"Disorder Type\" : \""
				+ orphapacket.getORPHApacket().get(0).getDisorderType().get(0).getName().get(0).getLabel() + "\" , ";
		elasticLine += "\"Disorder Type PURL\" : \""
				+ orphapacket.getORPHApacket().get(0).getDisorderType().get(0).getPURL() + "\" , ";
		
		
		
		// EXTERNAL REFERENCE
		try {
			
			int ExternalReferenceCount = Integer
					.parseInt(orphapacket.getORPHApacket().get(0).getExternalReferenceList().get(0).getCount());
			
			
			String ExternalReferenceLine = "\"ExternalReference Count\" : " + ExternalReferenceCount
					+ " , \"ExternalReference\" : [ ";
			for (int i = 0; i < ExternalReferenceCount; i++) {
				String Reference = orphapacket.getORPHApacket().get(0).getExternalReferenceList().get(0)
						.getExternalReference().get(i).getReference();
				String Source = orphapacket.getORPHApacket().get(0).getExternalReferenceList().get(0)
						.getExternalReference().get(i).getSource();
				String DisorderMappingRelationName = orphapacket.getORPHApacket().get(0).getExternalReferenceList()
						.get(0).getExternalReference().get(i).getDisorderMappingRelation().get(0)
						.getDisorderMappingRelationName().get(0).getLabel();
				String DisorderMappingRelationId = orphapacket.getORPHApacket().get(0).getExternalReferenceList().get(0)
						.getExternalReference().get(0).getDisorderMappingRelation().get(0)
						.getDisorderMappingRelationId();
				ExternalReferenceLine += "[\"" + Reference + "\" , \"" + Source + "\" , \"" + DisorderMappingRelationId
						+ "\" , \"" + DisorderMappingRelationName + "\"] , ";
			}
			elasticLine += new StringBuilder(ExternalReferenceLine).deleteCharAt(ExternalReferenceLine.length() - 2)
					.toString() + "] , ";
		} catch (Exception e6) {
			elasticLine += "\"ExternalReference Count\" : " + 0 + " , \"ExternalReference\" : [ \" \" ] , ";
		}			
		
		
			
		
		
		// GENES
		try {
			int DisorderGeneAssociationCount = Integer.parseInt(orphapacket.getORPHApacket().get(0).getDisorderGeneAssociationList().get(0).getCount());
			String DisorderGeneAssociationLine = "\"DisorderGeneAssociation Count\" : " + DisorderGeneAssociationCount	+ " , \"DisorderGeneAssociations\" : [ ";
			for (int i = 0; i < DisorderGeneAssociationCount; i++) {
				DisorderGeneAssociationLine += "[ \"DisorderGeneAssociationType\" : \"" + orphapacket.getORPHApacket().get(0).getDisorderGeneAssociationList().get(0).getDisorderGeneAssociation().get(i).getDisorderGeneAssociationType().get(0).getName().get(0).getLabel() + "\" , ";
				DisorderGeneAssociationLine += "\"DisorderGeneAssociation ORPHAnum\" : \"" + orphapacket.getORPHApacket().get(0).getDisorderGeneAssociationList().get(0).getDisorderGeneAssociation().get(i).getDisorderGeneAssociationType().get(0).getOrphaNumber() + "\" ,";
				DisorderGeneAssociationLine += "\"Genes\" : [ \"Gene Symbol\" : \"" + orphapacket.getORPHApacket().get(0).getDisorderGeneAssociationList().get(0).getDisorderGeneAssociation().get(i).getGene().get(0).getSymbol() + "\" , ";
				DisorderGeneAssociationLine += "\"Gene Name\" : \"" + orphapacket.getORPHApacket().get(0).getDisorderGeneAssociationList().get(0).getDisorderGeneAssociation().get(i).getGene().get(0).getName().get(0).getLabel() + "\" , ";
				try {
					int GeneExternalReferenceCount = Integer.parseInt(orphapacket.getORPHApacket().get(0).getDisorderGeneAssociationList().get(0).getDisorderGeneAssociation().get(i).getGene().get(0).getExternalReferenceList().get(0).getCount());
					System.out.println(GeneExternalReferenceCount);
					DisorderGeneAssociationLine += "\"GeneExternalReferenceCount\" : " + GeneExternalReferenceCount + " , \"GeneExternalReferences\" : [ ";
					for (int j = 0; j < GeneExternalReferenceCount; j++) {
						DisorderGeneAssociationLine += "[ \"Reference\" : \"" + orphapacket.getORPHApacket().get(0).getDisorderGeneAssociationList().get(0).getDisorderGeneAssociation().get(i).getGene().get(0).getExternalReferenceList().get(0).getExternalReference().get(j).getReference() + "\" , ";
						DisorderGeneAssociationLine += "\"Source\" : \"" + orphapacket.getORPHApacket().get(0).getDisorderGeneAssociationList().get(0).getDisorderGeneAssociation().get(i).getGene().get(0).getExternalReferenceList().get(0).getExternalReference().get(j).getSource() + "\" ] ,";
					}
				} catch (Exception e) {
					DisorderGeneAssociationLine += "\"GeneExternalReferenceCount\" : " + 0 + " , \"GeneExternalReferences\" : [ \" \" ] ";
				}
				DisorderGeneAssociationLine = new StringBuilder(DisorderGeneAssociationLine).deleteCharAt(DisorderGeneAssociationLine.length() - 1).toString() + " ] , ";
			}

			// System.out.println(DisorderGeneAssociationLine);
			elasticLine += new StringBuilder(DisorderGeneAssociationLine).deleteCharAt(DisorderGeneAssociationLine.length() - 2).toString() + "] , ";
		} catch (Exception e3) {
			elasticLine += "\"DisorderGeneAssociation Count\" : " + 0 + " , \"DisorderGeneAssociations\" : [ \" \" ] , ";
		}



		// HPO
		try {

			int hpoAssociationCount = orphapacket.getORPHApacket().get(0).getHPODisorderAssociationList().get(0)
					.getHPODisorderAssociation().size();
			String HPOValidationStatus = orphapacket.getORPHApacket().get(0).getHPODisorderSetStatus().get(0)
					.getValidationStatus();
			String hpoDisorderAssociationLine = "\"HPOValidationStatus\" : \"" + HPOValidationStatus
					+ "\" , \"HPODisorderAssociation Count\" : " + hpoAssociationCount
					+ " , \"HPODisorderAssociations\" : [ ";

			for (int i = 0; i < hpoAssociationCount; i++) {

				String HPOId = orphapacket.getORPHApacket().get(0).getHPODisorderAssociationList().get(0)
						.getHPODisorderAssociation().get(i).getHPOId();
				String HPOTerm = orphapacket.getORPHApacket().get(0).getHPODisorderAssociationList().get(0)
						.getHPODisorderAssociation().get(i).getHPOTerm();
				String PURL = orphapacket.getORPHApacket().get(0).getHPODisorderAssociationList().get(0)
						.getHPODisorderAssociation().get(i).getPURL();
				String HPOFrequency = orphapacket.getORPHApacket().get(0).getHPODisorderAssociationList().get(0)
						.getHPODisorderAssociation().get(i).getHPOFrequency().get(0).getName().get(0).getLabel();
				hpoDisorderAssociationLine += "[\"" + HPOId + "\" , \"" + HPOTerm + "\" , \"" + HPOFrequency + "\" , \""
						+ PURL + "\"] , ";

			}
			elasticLine += new StringBuilder(hpoDisorderAssociationLine)
					.deleteCharAt(hpoDisorderAssociationLine.length() - 2).toString() + "] , ";
		} catch (Exception e5) {
			elasticLine += "\"HPOValidationStatus\" : \"n\" , \"HPODisorderAssociation Count\" : " + 0
					+ " , \"HPODisorderAssociations\" : [ \" \" ] , ";

		}

		// ONSET
		try {

			int AgeOnsetCount = orphapacket.getORPHApacket().get(0).getAverageAgeOfOnsetList().get(0)
					.getAverageAgeOfOnset().size();
			String AverageAgeOfOnsetLine = "\"AgeOnset Count\" : " + AgeOnsetCount + " , \"AverageAgeOfOnset\" : [ ";
			for (int i = 0; i < AgeOnsetCount; i++) {
				AverageAgeOfOnsetLine += "\"" + orphapacket.getORPHApacket().get(0).getAverageAgeOfOnsetList().get(0)
						.getAverageAgeOfOnset().get(i).getName().get(0).getLabel() + "\" , ";
			}
			elasticLine += new StringBuilder(AverageAgeOfOnsetLine).deleteCharAt(AverageAgeOfOnsetLine.length() - 2)
					.toString() + "] , ";
		} catch (Exception e4) {
			elasticLine += "\"AgeOnset Count\" : " + 0 + " , \"AverageAgeOfOnset\" : [ \" \" ] , ";
		}

		// TYPEOFINHERITANCE
		try {

			int inheritanceCount = Integer
					.parseInt(orphapacket.getORPHApacket().get(0).getTypeOfInheritanceList().get(0).getCount());
			String inheritanceLine = "\"TypeOfInheritance Count\" : " + inheritanceCount
					+ " , \"TypeOfInheritance\" : [ ";
			for (int i = 0; i < inheritanceCount; i++) {
				inheritanceLine += "\"" + orphapacket.getORPHApacket().get(0).getTypeOfInheritanceList().get(0)
						.getTypeOfInheritance().get(i).getName().get(0).getLabel() + "\" , ";
			}
			elasticLine += new StringBuilder(inheritanceLine).deleteCharAt(inheritanceLine.length() - 2).toString()
					+ "] , ";
		} catch (Exception e4) {
			elasticLine += "\"TypeOfInheritance Count\" : " + 0 + " , \"TypeOfInheritance\" : [ \" \" ] , ";

		}

		// HASSUBTYPE
		// Size of HasSubtypeList tested.... only 1
		// Loop is on hasSubtypesCount and Disorder Subtype has DisorderGeneAssociation data !!!
		  try { 
			  int hasSubtypesCount = orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(0).getSubtype().size();
			  String subtypeLine = "\"Subtypes Count\" : " + hasSubtypesCount + " , \"HasSubtypes\" : [ ";
			  for (int subtype = 0; subtype < hasSubtypesCount;subtype++) {
				  subtypeLine += "[\"Subtype ORPHA\" : \"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(subtype).getSubtype().get(0).getDisorder().get(0).getORPHA() + "\" , "; 
				  subtypeLine += "\"Subtype PURL\" : \"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(subtype).getSubtype().get(0).getDisorder().get(0).getPURL() + "\" , ";
				  subtypeLine += "\"Subtype Name\" : \"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(subtype).getSubtype().get(0).getDisorder().get(0).getName().get(0).getLabel() + "\" , ";
				  try {
					int DisorderGeneAssociationCount = orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(subtype).getSubtype().get(0).getDisorder().get(0).getDisorderGeneAssociation().size();
					subtypeLine += "\"DisorderGeneAssociation Count\" : " + DisorderGeneAssociationCount	+ " , \"DisorderGeneAssociations\" : [ ";
					for (int genes=0 ; genes < DisorderGeneAssociationCount ; genes++) {
						subtypeLine += "[\"DisorderGeneAssociationType\" : \"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(subtype).getSubtype().get(0).getDisorder().get(0).getDisorderGeneAssociation().get(genes).getDisorderGeneAssociationType().get(0).getName().get(0).getLabel() + "\" , ";
						subtypeLine += "\"DisorderGeneAssociation ORPHAnum\" : \"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(subtype).getSubtype().get(0).getDisorder().get(0).getDisorderGeneAssociation().get(genes).getDisorderGeneAssociationType().get(0).getOrphaNumber() + "\" , ";
						subtypeLine += "\"Gene Symbol\" : \"" +  orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(subtype).getSubtype().get(0).getDisorder().get(0).getDisorderGeneAssociation().get(genes).getGene().get(0).getSymbol() + "\" , ";
						subtypeLine += "\"Gene Name\" : \"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(subtype).getSubtype().get(0).getDisorder().get(0).getDisorderGeneAssociation().get(genes).getGene().get(0).getName().get(0).getLabel() + "\" , ";
						try {
							int GeneExternalReferenceCount = orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(subtype).getSubtype().get(0).getDisorder().get(0).getDisorderGeneAssociation().get(genes).getGene().get(0).getExternalReferenceList().size();
							subtypeLine += "\"GeneExternalReferenceCount\" : " + GeneExternalReferenceCount + " , \"GeneExternalReferences\" : [ ";
							for (int generef=0 ; generef < GeneExternalReferenceCount ; generef++) {
								subtypeLine += "[ \"Reference\" : \"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(subtype).getSubtype().get(0).getDisorder().get(0).getDisorderGeneAssociation().get(genes).getGene().get(0).getExternalReferenceList().get(0).getExternalReference().get(generef).getReference() + "\" , ";
								subtypeLine += "\"Source\" : \"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(subtype).getSubtype().get(0).getDisorder().get(0).getDisorderGeneAssociation().get(genes).getGene().get(0).getExternalReferenceList().get(0).getExternalReference().get(generef).getSource() + "\" ] ";
							}
							
							
						} catch (Exception e) {
							subtypeLine += "\"GeneExternalReferenceCount\" : " + 0 + " , \"GeneExternalReferences\" : [ \" \" ] ";
							//e.printStackTrace();
						}
						
					}
					
					
				} catch (Exception e) {
					subtypeLine += "\"DisorderGeneAssociation Count\" : " + 0 + " , \"DisorderGeneAssociations\" : [ \" \" ] , ";
					//e.printStackTrace();
				}
			}

			  
		  } catch (Exception e3) { 
			  
			  elasticLine += "\"Subtypes Count\" : " + 0 + " , \"HasSubtypes\" : [ \" \" ] , ";
			  //e3.printStackTrace(); 
			  
		  }
		  
		  
		  
		  
		  
		  
		  
		  
		
		
		// SUBCLASS OF
		//NEED TO SEE SubClassFixer.sh !!!!!
		////
		//DisorderGeneAssociation Tested ---> never encountered
		try {
			int hasParentCount = orphapacket.getORPHApacket().get(0).getSubClassOfList().size();
			String hasParentLine = "\"Parents Count\" : " + hasParentCount + " , \"HasParents\" : [ ";
			for (int i = 0; i < hasParentCount; i++) {
				hasParentLine += "[\"Parent ORPHA\" : \"" + orphapacket.getORPHApacket().get(0).getSubClassOfList().get(0).getDisorder().get(i).getORPHA() + "\" , ";
				hasParentLine += "\" Parent PURL\" : \"" + orphapacket.getORPHApacket().get(0).getSubClassOfList().get(0).getDisorder().get(i).getPURL() + "\" , ";
				hasParentLine += "\" Parent Name\" : \"" + orphapacket.getORPHApacket().get(0).getSubClassOfList().get(0).getDisorder().get(i).getName().get(0).getLabel() + "\"] , ";		
			}
			elasticLine += new StringBuilder(hasParentLine).deleteCharAt(hasParentLine.length() - 2).toString()	+ "] , ";
		} catch (Exception e2) {
			elasticLine += "\"Parents Count\" : " + 0 + " , \"HasParents\" : [ \" \" ] , ";

		}

		
		
		
		
		
		// SYNONYMES
		try {
			int synonymesCount = Integer
					.parseInt(orphapacket.getORPHApacket().get(0).getSynonymList().get(0).getCount());
			String synomymLine = "\"Synonyms Count\" : " + synonymesCount + " , \"Synonyms\" : [ ";
			for (int i = 0; i < synonymesCount; i++) {
				synomymLine += "\""
						+ orphapacket.getORPHApacket().get(0).getSynonymList().get(0).getSynonym().get(i).getLabel()
						+ "\" , ";
			}
			elasticLine += new StringBuilder(synomymLine).deleteCharAt(synomymLine.length() - 2).toString() + "] , ";

		} catch (Exception e1) {
			elasticLine += "\"Synonyms Count\" : " + 0 + " , \"Synonyms\" : [ \" \" ] , ";

		}

		// TEXT SECTION
		try {
			elasticLine += "\"TextSection Type\" : \""
					+ orphapacket.getORPHApacket().get(0).getTextSection().get(0).getName().get(0).getLabel() + "\" , ";
			elasticLine += "\"Contents\" : \""
					+ orphapacket.getORPHApacket().get(0).getTextSection().get(0).getContents() + "\" } ";
		} catch (Exception e) {
			elasticLine += "\"TextSection Type\" : \" \" , \"Contents\" : \" \"  ";
		}

		
		
		
		
		
		
		
		// System.out.println(elasticLine.length()-1);
		String elasticLinetmp = new StringBuilder(elasticLine).deleteCharAt(elasticLine.length() - 2).toString() + "";
		// System.out.println(elasticLinetmp);
		elasticLinetmp += "}";
		writer.write(elasticLinetmp);
		writer.write("\n");

	}
}
