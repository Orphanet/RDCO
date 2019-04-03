package ORPHApackets;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class TextSectionParser {
	
	private String Contents;
	private List<NameParser> Name;
			
		
	
	
	
	@JsonProperty("Contents")
	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
	}
	
	@JsonProperty("Name")
	public List<NameParser> getName() {
		return Name;
	}
	public void setName(List<NameParser> name) {
		Name = name;
	}
	

}
