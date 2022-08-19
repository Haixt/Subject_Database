package com.iac.model.professor;



public class DataComProfessor implements Professor {

	private final String NAME = "Subject Professor: Mitch Andaya";
	private final String EXPERIENCE = "Years of Experience : 30 years";
	
	 @Override
	 	public Professor clone() {
        return new  DataComProfessor();
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