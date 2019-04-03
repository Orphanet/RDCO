package ORPHApackets;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class ORPHApacket {

	
	private List<ORPHApacketParser> ORPHApacket;

	
	@JsonProperty("ORPHApacket")
	public List<ORPHApacketParser> getORPHApacket() {
		return ORPHApacket;
	}

	public void setORPHApacket(List<ORPHApacketParser> oRPHApacket) {
		ORPHApacket = oRPHApacket;
	}

	
}