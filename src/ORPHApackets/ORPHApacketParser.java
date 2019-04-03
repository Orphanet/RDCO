package ORPHApackets;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ORPHApacketParser {

	private String ORPHApacketID;
	private String PURL;
	private String ORPHA;
	private String date;
	private String version;
	private String copyright;
	private List<DisorderTypeParser> DisorderType;
	private List<NameParser> Name;
	private List<TextSectionParser> TextSection;
	private List<SynonymListParser> SynonymList;
	
	private List<SubClassOfListParser> SubClassOfList;
	
	private List<HasSubtypeListParser> HasSubtypeList;
	private List<TypeOfInheritanceListParser> TypeOfInheritanceList;
	private List<AverageAgeOfOnsetListParser> AverageAgeOfOnsetList;
	private List<HPODisorderAssociationListParser> HPODisorderAssociationList;
	private List<HPODisorderSetStatusParser> HPODisorderSetStatus;
	private List<ExternalReferenceListParser> ExternalReferenceList;
	private List<DisorderGeneAssociationListParser> DisorderGeneAssociationList;
	
	
	@JsonProperty("HasSubtypeList")
	public List<HasSubtypeListParser> getHasSubtypeList() {
		return HasSubtypeList;
	}
	public void setHasSubtypeList(List<HasSubtypeListParser> hasSubtypeList) {
		HasSubtypeList = hasSubtypeList;
	}
	
	
	
	
	@JsonProperty("ORPHApacketID")
	public String getORPHApacketID() {
		return ORPHApacketID;
	}
	public void setORPHApacketID(String oRPHApacketID) {
		ORPHApacketID = oRPHApacketID;
	}
	@JsonProperty("PURL")
	public String getPURL() {
		return PURL;
	}
	public void setPURL(String pURL) {
		PURL = pURL;
	}
	@JsonProperty("ORPHA")
	public String getORPHA() {
		return ORPHA;
	}
	public void setORPHA(String oRPHA) {
		ORPHA = oRPHA;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	
	
	@JsonProperty("DisorderType")
	public List<DisorderTypeParser> getDisorderType() {
		return DisorderType;
	}
	public void setDisorderType(List<DisorderTypeParser> disorderType) {
		DisorderType = disorderType;
	}
	
	
	@JsonProperty("Name")
	public List<NameParser> getName() {
		return Name;
	}

	public void setName(List<NameParser> name) {
		Name = name;
	}

	@JsonProperty("TextSection")
	public List<TextSectionParser> getTextSection() {
		return TextSection;
	}
	public void setTextSection(List<TextSectionParser> textSection) {
		TextSection = textSection;
	}
	
	@JsonProperty("SynonymList")
	public List<SynonymListParser> getSynonymList() {
		return SynonymList;
	}
	public void setSynonymList(List<SynonymListParser> synonymList) {
		SynonymList = synonymList;
	}
	
	
	
	
	
	@JsonProperty("SubClassOfList")
	public List<SubClassOfListParser> getSubClassOfList() {
		return SubClassOfList;

	}
	
	public void setSubClassOfList(List<SubClassOfListParser> subClassOfList) {
		SubClassOfList = subClassOfList;
	}
	
	
	
	
	
	
	
	@JsonProperty("TypeOfInheritanceList")
	public List<TypeOfInheritanceListParser> getTypeOfInheritanceList() {
		return TypeOfInheritanceList;
	}
	public void setTypeOfInheritanceList(List<TypeOfInheritanceListParser> typeOfInheritanceList) {
		TypeOfInheritanceList = typeOfInheritanceList;
	}
	
	
	
	@JsonProperty("AverageAgeOfOnsetList")
	public List<AverageAgeOfOnsetListParser> getAverageAgeOfOnsetList() {
		return AverageAgeOfOnsetList;
	}
	public void setAverageAgeOfOnsetList(List<AverageAgeOfOnsetListParser> averageAgeOfOnsetList) {
		AverageAgeOfOnsetList = averageAgeOfOnsetList;
	}
	
	@JsonProperty("HPODisorderAssociationList")
	public List<HPODisorderAssociationListParser> getHPODisorderAssociationList() {
		return HPODisorderAssociationList;
	}
	public void setHPODisorderAssociationList(List<HPODisorderAssociationListParser> hPODisorderAssociationList) {
		HPODisorderAssociationList = hPODisorderAssociationList;
	}
	
	@JsonProperty("HPODisorderSetStatus")
	public List<HPODisorderSetStatusParser> getHPODisorderSetStatus() {
		return HPODisorderSetStatus;
	}
	public void setHPODisorderSetStatus(List<HPODisorderSetStatusParser> hPODisorderSetStatus) {
		HPODisorderSetStatus = hPODisorderSetStatus;
	}
	
	@JsonProperty("ExternalReferenceList")
	public List<ExternalReferenceListParser> getExternalReferenceList() {
		return ExternalReferenceList;
	}
	public void setExternalReferenceList(List<ExternalReferenceListParser> externalReferenceList) {
		ExternalReferenceList = externalReferenceList;
	}
	
	@JsonProperty("DisorderGeneAssociationList")
	public List<DisorderGeneAssociationListParser> getDisorderGeneAssociationList() {
		return DisorderGeneAssociationList;
	}
	public void setDisorderGeneAssociationList(List<DisorderGeneAssociationListParser> disorderGeneAssociationList) {
		DisorderGeneAssociationList = disorderGeneAssociationList;
	}
	
}
