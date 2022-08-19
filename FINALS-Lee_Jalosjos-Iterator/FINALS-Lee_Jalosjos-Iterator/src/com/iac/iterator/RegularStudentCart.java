package com.iac.iterator;

import java.util.ArrayList;
import java.util.Iterator;

import com.iac.builder.SubjectBuilder;
import com.iac.builder.SubjectList;
import com.iac.model.subject.DataCom;
import com.iac.model.subject.JavaEE;
import com.iac.model.subject.MobCom;
import com.iac.model.subject.WebProg;





public class RegularStudentCart implements SubjectIterator {
	ArrayList<SubjectBuilder> regularSubjects;
	
	public SubjectList RegularStudentCart(){
		
	regularSubjects = new ArrayList<SubjectBuilder>();
	SubjectList sl = new SubjectList();
	sl.addItem(new JavaEE());
	sl.addItem(new DataCom());
	sl.addItem(new MobCom());
	sl.addItem(new WebProg());
	return sl;
}

	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return regularSubjects.iterator();
	}
}
