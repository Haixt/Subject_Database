package com.iac.model.subject;

import com.iac.builder.Item;



public interface StudentSubject extends Item{

	StudentSubject clone();
	public abstract String viewSubject();
	public abstract String viewDescription();
	public abstract String name();
	public abstract double price();
}
