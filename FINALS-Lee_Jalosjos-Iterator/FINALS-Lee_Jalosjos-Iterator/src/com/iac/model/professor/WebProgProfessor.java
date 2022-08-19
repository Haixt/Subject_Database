package com.iac.model.professor;

public class WebProgProfessor implements Professor {

	private final String NAME = "Subject Professor: Karla Recalde";
	private final String EXPERIENCE = "Years of experience: 10 years";
	
	 @Override
    public Professor clone() {
        return new  WebProgProfessor();
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

