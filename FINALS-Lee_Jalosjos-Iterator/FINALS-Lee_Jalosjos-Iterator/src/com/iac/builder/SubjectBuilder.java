package com.iac.builder;

import com.iac.model.subject.DataCom;
import com.iac.model.subject.JavaEE;
import com.iac.model.subject.MobCom;
import com.iac.model.subject.WebProg;

public class SubjectBuilder {

	public SubjectList present_regularStudent(){
		SubjectList sl = new SubjectList();
		sl.addItem(new JavaEE());
		sl.addItem(new DataCom());
		sl.addItem(new MobCom());
		sl.addItem(new WebProg());
		return sl;
	}
	public SubjectList present_iregularStudent(){
		SubjectList sl = new SubjectList();
		sl.addItem(new MobCom());
		sl.addItem(new WebProg());
		return sl;
	}
}
