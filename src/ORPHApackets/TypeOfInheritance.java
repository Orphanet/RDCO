package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class TypeOfInheritance {
	
	
	private List<Name> TypeOfInheritance;
	
	@JsonProperty("TypeOfInheritance")
	public List<Name> getTypeOfInheritance() {
		return TypeOfInheritance;
	}

	public void setTypeOfInheritance(List<Name> typeOfInheritance) {
		TypeOfInheritance = typeOfInheritance;
	}
	
	
	

}
