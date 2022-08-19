package com.iac.utility;

import com.iac.model.subject.*;
import com.iac.model.professor.*;

public interface AbstractFactory {

	StudentSubject getSubject(String input); 
	Professor getProfessor(String name);

}
