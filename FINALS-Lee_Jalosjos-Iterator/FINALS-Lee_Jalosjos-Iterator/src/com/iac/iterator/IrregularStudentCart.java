package com.iac.iterator;

import java.util.ArrayList;
import java.util.Iterator;

import com.iac.builder.SubjectBuilder;
import com.iac.builder.SubjectList;
import com.iac.model.subject.MobCom;
import com.iac.model.subject.WebProg;

public class IrregularStudentCart implements SubjectIterator{

	ArrayList<SubjectBuilder> irregularSubjects;
	
	public SubjectList IrregularStudentCart(){
		irregularSubjects = new ArrayList<SubjectBuilder>();
		SubjectList sl = new SubjectList();
		sl.addItem(new MobCom());
		sl.addItem(new WebProg());
		return sl;
	}
	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
