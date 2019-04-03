package RDCO;

import java.util.List;












import RDCO.algorithms.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MethodParser {
	private String method;
	private List<ResultParser> results;
	private RDCO rdcoParent;
	private Algorithm algo;
	
	@JsonProperty("method")
	public String getMethod() {
		return method;
	}
	
	@JsonProperty("results")
	public List<ResultParser> getResults() {
		return results;
	}
	
	public void setResult(List<ResultParser> results) {
		this.results = results;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	public RDCO getRDCOParent(){
		return rdcoParent;
	}
	public void setRDCOParent(RDCO parent){
		rdcoParent = parent;
	}
	
	public String getPhenoId(){
		return rdcoParent.getPhenoId();
	}

	public Algorithm getAlgo() {
		return algo;
	}

	public void setAlgo(Algorithm algo) {
		this.algo = algo;
	}
	public String toString(){
		String text = "Method : "+method;
		for(ResultParser res : results){
			
			text+="\n\t\t-"+res.toString();
			
		}
		return text;
	}
	
	public void instaniateObjects(){
		try {
			String[] test = method.split("[^\\w]");
			String className = "";
			
			for(String s: test){
				if(s.equals("standard")){
					s="St";
				}
				if(s.length()>0 && !s.equals("Similarity")){
					className += s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
				}
			}
			Class<?> cls =  Class.forName("RDCO.algorithms."+className);
			algo = (Algorithm) cls.newInstance();
			System.out.println("algo label : "+algo.getLabel()+"; id : "+algo.getId());
			
		}catch (ClassNotFoundException e) {
            e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(ResultParser res : results){	
			res.setMethodParent(this);
			res.instantiateLinkedConcept();			
		}
	}

	public String toOWL() {
		String owl="";
		for(ResultParser res : results){
			
			owl+=res.toOWL();
			
		}
		return owl;
	}
	
	
	public String getDeclaration(){			
		String declaraltion = algo.getDeclaration();
		for(ResultParser res : results){			
			declaraltion+=res.getDeclaration();			
		}
		return declaraltion;
	}

	
}
