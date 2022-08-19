package com.iac.model.professor;

public class MobComProfessor implements Professor {

	
	private final String NAME = "Subject Professor: Ronald Ramos";
	private final String EXPERIENCE = "Years of experience: 25 years";
	
	 @Override
    public Professor clone() {
        return new  MobComProfessor();
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
