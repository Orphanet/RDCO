package ORPHApackets;

import java.io.BufferedWriter;
import java.io.IOException;

public class ORPHApacketServiceELKNested {

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

		
		
		// EXTERNAL REFERENCE ELK NESTED
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
				ExternalReferenceLine += "{\"Reference\" : \"" + Reference + "\" , \"Source\" : \"" + Source + "\" , \"DisorderMappingRelationId\" : \"" + DisorderMappingRelationId
						+ "\" , \"DisorderMappingRelationName\" : \"" + DisorderMappingRelationName + "\"} , ";
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
				String DisorderGeneAssociationLinetmp1 = "{\"DisorderGeneAssociation ORPHAnum\" : \"" + orphapacket.getORPHApacket().get(0).getDisorderGeneAssociationList().get(0).getDisorderGeneAssociation().get(i).getDisorderGeneAssociationType().get(0).getOrphaNumber() + "\" ,";
				DisorderGeneAssociationLinetmp1 += "\"Genes\" : [ {\"Gene Symbol\" : \"" + orphapacket.getORPHApacket().get(0).getDisorderGeneAssociationList().get(0).getDisorderGeneAssociation().get(i).getGene().get(0).getSymbol() + "\" , ";
				DisorderGeneAssociationLinetmp1 += "\"Gene Name\" : \"" + orphapacket.getORPHApacket().get(0).getDisorderGeneAssociationList().get(0).getDisorderGeneAssociation().get(i).getGene().get(0).getName().get(0).getLabel() + "\" , ";
				try {
					int GeneExternalReferenceCount = Integer.parseInt(orphapacket.getORPHApacket().get(0).getDisorderGeneAssociationList().get(0).getDisorderGeneAssociation().get(i).getGene().get(0).getExternalReferenceList().get(0).getCount());
					DisorderGeneAssociationLine += "\"GeneExternalReferenceCount\" : " + GeneExternalReferenceCount + " , \"GeneExternalReferences\" : [ ";
		
					for (int j = 0; j < GeneExternalReferenceCount; j++) {
						DisorderGeneAssociationLine += "{\"Reference\" : \"" + orphapacket.getORPHApacket().get(0).getDisorderGeneAssociationList().get(0).getDisorderGeneAssociation().get(i).getGene().get(0).getExternalReferenceList().get(0).getExternalReference().get(j).getReference() + "\" , ";
						DisorderGeneAssociationLine += "\"Source\" : \"" + orphapacket.getORPHApacket().get(0).getDisorderGeneAssociationList().get(0).getDisorderGeneAssociation().get(i).getGene().get(0).getExternalReferenceList().get(0).getExternalReference().get(j).getSource() + "\"},";
					}
					
					String toto = new StringBuilder(DisorderGeneAssociationLine).deleteCharAt(DisorderGeneAssociationLine.length() - 1).toString() + "]";
					System.out.println(toto);
					
					
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


		
		
		
		
		
		
		// System.out.println(elasticLine.length()-1);
		String elasticLinetmp = new StringBuilder(elasticLine).deleteCharAt(elasticLine.length() - 2).toString() + "";
		// System.out.println(elasticLinetmp);
		elasticLinetmp += "}";
		writer.write(elasticLinetmp);
		writer.write("\n");

	}
}
