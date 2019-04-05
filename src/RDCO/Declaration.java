package RDCO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Declaration {
	@SuppressWarnings("rawtypes")
	static HashMap<String, Boolean> declared = new HashMap<>();
	
	public static String Declare(Object obj){
		if(isDeclared(obj)){
			return "";
		}
		try{

			Method getDeclaration =  obj.getClass().getMethod("getDeclaration");
			String declaration = (String) getDeclaration.invoke(obj);
						
			return declaration;
			
		}catch(Exception e){
			System.out.println("NO DECLARATION FOR OBJECT : "+obj.getClass().toString()+" => "+e.toString() );
			e.printStackTrace();
			return "";
		}
	}
	public Boolean hasId(Object obj){
		return false;
	}
	
	public static Boolean isDeclared(Object obj){
		
		try {
			Method getId =  obj.getClass().getMethod("getId");
			String id;
			
			id = (String) getId.invoke(obj);
				
			if(declared.containsKey(obj.getClass().getName() + id) ){				
				return true;
			}

			declared.put(obj.getClass().getName() + id,true);
			return false;
		} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
			return false;
		}
			

	}
	
	
}
