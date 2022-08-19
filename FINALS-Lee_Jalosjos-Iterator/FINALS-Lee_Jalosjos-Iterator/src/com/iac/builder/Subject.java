package com.iac.builder;

import com.iac.builder.Packing;


public abstract class Subject implements Item {

	 @Override
	   public Packing pack() {
	      return new Wrapper();
	   }
}
