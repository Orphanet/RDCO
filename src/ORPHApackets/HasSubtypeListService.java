package ORPHApackets;

public class HasSubtypeListService {

	public String generateSubtypeLine(ORPHApacket orphapacket) {

		String parentOfLine = "";
		try {
			int parentOfListCount = orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(0).getSubtype().size();
			parentOfLine += "\"ParentOf Count\" : " + parentOfListCount + " , \"ParentOf\" : [ [";
			for (int i = 0; i < parentOfListCount; i++) {
				parentOfLine += "\"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(0).getSubtype()
						.get(i).getDisorder().get(0).getName().get(0).getLabel() + "\" , ";
				parentOfLine += "\"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(0).getSubtype()
						.get(i).getDisorder().get(0).getORPHA() + "\" , ";
				parentOfLine += "\"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(0).getSubtype()
						.get(i).getDisorder().get(0).getPURL() + "\" , ";

				// DisorderGeneAssociation

				try {
					int disorderGeneAssociationCount = orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(0)
							.getSubtype().get(i).getDisorder().get(0).getDisorderGeneAssociation().size();
					parentOfLine += "\"DisorderGeneAssociation Count\" : " + disorderGeneAssociationCount
							+ " , \"DisorderGeneAssociation\" : [ [";
					for (int j = 0; j < disorderGeneAssociationCount; j++) {
						parentOfLine += "\"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(0)
								.getSubtype().get(i).getDisorder().get(0).getDisorderGeneAssociation().get(j)
								.getDisorderGeneAssociationType().get(0).getName().get(0).getLabel() + "\" , ";
						parentOfLine += "\"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(0)
								.getSubtype().get(i).getDisorder().get(0).getDisorderGeneAssociation().get(j)
								.getDisorderGeneAssociationType().get(0).getOrphaNumber() + "\" , ";
						parentOfLine += "\"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(0)
								.getSubtype().get(i).getDisorder().get(0).getDisorderGeneAssociation().get(j).getGene()
								.get(0).getName().get(0).getLabel() + "\" , ";
						parentOfLine += "\"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(0)
								.getSubtype().get(i).getDisorder().get(0).getDisorderGeneAssociation().get(j).getGene()
								.get(0).getSymbol() + "\" , \"ExternalReference\" : [";

						try {
							int externalReferenceCount = Integer
									.parseInt(orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(i)
											.getSubtype().get(0).getDisorder().get(0).getDisorderGeneAssociation()
											.get(j).getGene().get(0).getExternalReferenceList().get(0).getCount());
							for (int k = 0; k < externalReferenceCount; k++) {
								parentOfLine += "\"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(0)
										.getSubtype().get(i).getDisorder().get(0).getDisorderGeneAssociation().get(j)
										.getGene().get(0).getExternalReferenceList().get(k).getExternalReference()
										.get(0).getReference() + "\" , ";
								parentOfLine += "\"" + orphapacket.getORPHApacket().get(0).getHasSubtypeList().get(0)
										.getSubtype().get(i).getDisorder().get(0).getDisorderGeneAssociation().get(j)
										.getGene().get(0).getExternalReferenceList().get(k).getExternalReference()
										.get(0).getSource() + "\" , ";
							}
							parentOfLine += new StringBuilder(parentOfLine).deleteCharAt(parentOfLine.length() - 2)
									.toString() + "] , ";

						} catch (Exception e) {
							parentOfLine += "\" \"] , ";
							e.printStackTrace();
						}
					}
					parentOfLine += new StringBuilder(parentOfLine).deleteCharAt(parentOfLine.length() - 2).toString()
							+ "] , ";

				} catch (Exception e) {
					parentOfLine += "\"DisorderGeneAssociation Count\" : " + 0
							+ " , \"DisorderGeneAssociation\" : [ [ \" \" ] ] ";
					e.printStackTrace();
				}
			}
			parentOfLine += new StringBuilder(parentOfLine).deleteCharAt(parentOfLine.length() - 2).toString() + "] , ";

		} catch (Exception e3) {
			parentOfLine += "\"ParentOf Count\" : " + 0 + " , \"ParentOf\" : [ \" \" ] , ";
			return parentOfLine;

		}

		return parentOfLine;

	}

}
