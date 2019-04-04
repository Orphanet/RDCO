package RDCO;

public abstract class LinkedConcept {
	private String id;
	private String identifier;
	private String label;
	private String iri;

	public LinkedConcept(){}
	
	public LinkedConcept(String id, String label){
		this.id  = id;
		this.label = label;
	}
	
	public LinkedConcept(String id, String label, String iri, String identifier){
		this.id         = id;
		this.label      = label;
		this.iri        = iri;		
		this.identifier = identifier;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getIri() {
		return iri;
	}
	public void setIri(String iri) {
		this.iri = iri;
	}
	
	public String toString(){
		return id;
	}
	
	public String toOWL(){
		return "";
	}
	
	public String getDeclaration(){
		return "";
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
}
