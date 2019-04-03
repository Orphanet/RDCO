package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TypeOfInheritanceListParser {
	
	
	private List<TypeOfInheritanceParser> TypeOfInheritance;
	private String count;
	
	
	
	
	

	@JsonProperty("TypeOfInheritance")
	public List<TypeOfInheritanceParser> getTypeOfInheritance() {
		return TypeOfInheritance;
	}

	public void setTypeOfInheritance(List<TypeOfInheritanceParser> typeOfInheritance) {
		TypeOfInheritance = typeOfInheritance;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	

	
	
	
	
	
	
	

}
