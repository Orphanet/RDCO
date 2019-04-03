package ORPHApackets;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DisorderTypeParser {

	
	private String PURL;
	private List<NameParser> Name;
	
	
	
	@JsonProperty("Name")
	public List<NameParser> getName() {
		return Name;
	}

	public void setName(List<NameParser> name) {
		Name = name;
	}

	@JsonProperty("PURL")
	public String getPURL() {
		return PURL;
	}

	public void setPURL(String pURL) {
		PURL = pURL;
	}
	
	
	
	
	
}
