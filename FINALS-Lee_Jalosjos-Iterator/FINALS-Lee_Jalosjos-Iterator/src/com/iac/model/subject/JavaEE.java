package com.iac.model.subject;

import com.iac.builder.Packing;
import com.iac.builder.Wrapper;


public class JavaEE implements StudentSubject{

	private final String NAME = "Subject: Java Enterprise";
	private final String EXPERIENCE = "Description: Learn to incorporate the skills of Java and HTML";
	private final double PRICE = 10000;
	 @Override
    public StudentSubject clone() {
        return new  JavaEE();
    }


	@Override
	public String viewSubject() {
		return NAME;
	}

	@Override
	public String viewDescription() {
		return EXPERIENCE;
	}


	@Override
	public String name() {
		// TODO Auto-generated method stub
		return NAME;
	}


	@Override
	public double price() {
		// TODO Auto-generated method stub
		return PRICE;
	}


	@Override
	public Packing pack() {
		// TODO Auto-generated method stub
		 return new Wrapper();
	}

	
}


