package RDCO;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class RDCO {

	
	private List<MethodParser> Method;
	private String date;
	private String ontologyVersion;
	private String phenoId;
	private String baseIri = "http://www.semanticweb.org/RDCO_model_A_oct2018#";
	
	@JsonProperty("methods")
	public List<MethodParser> getMethod() {
		return Method;
	}
	public void setMethod(List<MethodParser> method) {
		Method = method;
	}
	
	@JsonProperty("annotation-data-version")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@JsonProperty("ontology-version")
	public String getOntologyVersion() {
		return ontologyVersion;
	}
	public void setOntologyVersion(String ontologyVersion) {
		this.ontologyVersion = ontologyVersion;
	}
	
	public void setPhenoPacketId(String phenoId){
		this.phenoId = phenoId;
	}
	public String getPhenoId(){
		return phenoId;
	}
	public String getBaseIri() {
		return baseIri;
	}
	public void setBaseIri(String baseIri) {
		this.baseIri = baseIri;
	}
	
	public String toString(){
		String text="date : "+date+"; version : "+ontologyVersion+";";
		for(MethodParser meth : Method){
			
			text+="\n\t-"+meth.toString();
			
		}
		return text;
	}
	
	public void instaniateObjects(){
		for(MethodParser meth : Method){	
			meth.setRDCOParent(this);
			meth.instaniateObjects();			
		}
	}	
	
	public String toOWL(){
		String owl="";
		for(MethodParser meth : Method){
			
			owl+=meth.toOWL();
			
		}
		return owl;
	}
	
	public String getDeclaration(){			
		String declaraltion = "";
		for(MethodParser meth : Method){		
			declaraltion+=meth.getDeclaration();			
		}
		return declaraltion;
	}
}