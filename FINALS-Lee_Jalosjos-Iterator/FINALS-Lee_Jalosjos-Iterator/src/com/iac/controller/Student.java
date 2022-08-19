
package com.iac.controller;


import java.util.Scanner;

import com.iac.model.creditcard.CreditBean;
import com.iac.model.professor.Professor;
import com.iac.model.subject.StudentSubject;
import com.iac.utility.Input;
import com.iac.utility.SingletonDB;
import com.iac.utility.SubjectFactory;
import com.iac.utility.TeacherFactory;
import com.iac.view.Display;

public class Student {
	
	private static char choice ;
	static Scanner input = new Scanner(System.in);
	
	public static void getOption() throws Exception{
		String[] menu = new String[8];
	    menu[0] = "\n[A]dd Subject";
	    menu[1] = "[C]heck Subjects";
	    menu[2] = "[D]isplay Cart";
		menu[3] = "[L]ist Subjects";
		menu[4] = "[P]ay";
		menu[5] = "[Q]uit";
		menu[6] = "[S]earch Subject";
	    menu[7] = "[T]runcate Table";
	    
	    
	    for(int i=0;i<menu.length;++i)
	    {
	    System.out.println(menu[i]);
	    }
	    
	    System.out.print("\nSelection option:   ");
	    choice= Character.toUpperCase((input.next().charAt(0)));  
	    
		Display.choicePath(choice);
	}
	
	
	
	
	
	public static void main(String[] args)throws Exception {
		SingletonDB.createTable();
		while(true){
			getOption();
		}
	}
}


