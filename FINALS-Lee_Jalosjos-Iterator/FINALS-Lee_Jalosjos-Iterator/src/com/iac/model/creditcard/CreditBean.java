package com.iac.model.creditcard;

import com.iac.model.subject.StudentSubject;
import com.iac.utility.SubjectFactory;
import com.iac.utility.LuhnCode;
import com.iac.utility.SingletonDB;

public class CreditBean implements Facade {

	
	@Override
	public void transaction(String card, String subjectName) {
		// TODO Auto-generated method stub
		if(LuhnCode.luhnTest(card)) {
		 StudentSubject subject = new SubjectFactory().getPrototype(subjectName);
			SingletonDB.insertTransactionRecord(subject);
			System.out.println("\nYour Card Is Valid, Transaction Success!");
		}else {
			System.err.println("\nYour Card Number Is Invalid, Try Again!");
		}
	}

}
