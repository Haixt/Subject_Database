package com.iac.utility;

import java.util.HashMap;
import java.util.Map;

import com.iac.model.professor.*;

public class TeacherFactory {
	
	
	 private static final Map<String, Professor> prototypes = new HashMap<>();

	  static {
	      prototypes.put("DATA COMMUNICATION", new DataComProfessor());
	      prototypes.put("JAVA ENTERPRISE", new JavaEEProfessor());
	      prototypes.put("MOBILE COMPUTING", new MobComProfessor());
	      prototypes.put("WEB PROGRAMMING", new WebProgProfessor());
	  }

	  public static Professor getPrototype(String type) {
		  	try {
		          return prototypes.get(type).clone();
		      
		      } catch (NullPointerException ex) {
		          System.out.println("Prototype with name: " + type + ", doesn't exist");
		          return null;
		      }
	  }
}





