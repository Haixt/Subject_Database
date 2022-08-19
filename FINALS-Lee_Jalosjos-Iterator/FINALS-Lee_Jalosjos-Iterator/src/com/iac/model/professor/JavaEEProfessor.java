package com.iac.model.professor;

public class JavaEEProfessor implements Professor {

	private final String NAME = "Subject Professor: Raymond Zalameda";
	private final String EXPERIENCE = "Years of experience: 26 years";
	
	 @Override
	 	public Professor clone() {
        return new  JavaEEProfessor();
    }

	 @Override
		public String viewProfessor() {
			return NAME;
		}

		@Override
		  public String viewExperience() {
			return EXPERIENCE;
		}
}