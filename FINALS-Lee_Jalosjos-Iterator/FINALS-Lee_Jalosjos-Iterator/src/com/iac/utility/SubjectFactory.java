package com.iac.utility;

import java.util.HashMap;
import java.util.Map;

import com.iac.model.subject.*;
import com.iac.model.professor.*;

public class SubjectFactory  {

	
	private static final Map<String, StudentSubject> prototypes = new HashMap<>();

	  static {
	      prototypes.put("DATA COMMUNICATION", new DataCom());
	      prototypes.put("JAVA ENTERPRISE", new JavaEE());
	      prototypes.put("MOBILE COMPUTING", new MobCom());
	      prototypes.put("WEB PROGRAMMING", new WebProg());
	  }
	  
	  public static StudentSubject getPrototype(String type) {
		  	try {
		          return prototypes.get(type).clone();
		      
		      } catch (NullPointerException ex) {
		          System.out.println("Prototype with name: " + type + ", doesn't exist");
		          return null;
		      }
		  }

}
