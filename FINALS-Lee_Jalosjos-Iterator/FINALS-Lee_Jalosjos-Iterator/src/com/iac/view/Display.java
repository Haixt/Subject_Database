package com.iac.view;

import java.util.Scanner;

import com.iac.builder.SubjectBuilder;
import com.iac.builder.SubjectList;
import com.iac.iterator.IrregularStudentCart;
import com.iac.iterator.RegularStudentCart;
import com.iac.model.subject.*;
import com.iac.model.creditcard.CreditBean;
import com.iac.model.professor.*;
import com.iac.utility.Input;
import com.iac.utility.SingletonDB;
import com.iac.utility.SubjectFactory;
import com.iac.utility.TeacherFactory;

public class Display {
	
	static Scanner input = new Scanner(System.in);
	private static String search_Id;
	private static int search_Choice;
	private static String is_Student;
	
public static void choicePath(char choice)throws Exception{
		
		switch (choice) {
			case 'A':
				
				System.out.println("\n\nList of Subjects:");
				System.out.println("1) Java Enterprise");
				System.out.println("2) Data Communication");
				System.out.println("3) Web Programming");
				System.out.println("4) Mobile Computing\n");
				
				String SubjectTypeInput = 
					Input.getString("").toUpperCase();
				
			
				StudentSubject subject = new SubjectFactory().getPrototype(SubjectTypeInput);
				
				//set the professor of the subject
				Professor professor = new TeacherFactory().getPrototype(SubjectTypeInput);
				
				
		
				SingletonDB.insertRecord(subject, professor);
				
				System.out.println("\nSubject has been added!");
				
				break;
				
			case 'L':
				SingletonDB.showRecord();
				
				break;
				
			case 'S':
				System.out.println("\nWhich one do you want to search? ");
				System.out.println("[1]Subject");
				System.out.println("[2]Professor");
				System.out.print("\nInput the number of choice: ");
				search_Choice = input.nextInt();  
				
				while(search_Choice <= 0 || search_Choice >= 3){
					System.out.println("Wrong input. Please try again");
					System.out.println("\nWhich one do you want to search? ");
					System.out.println("[1]Subject");
					System.out.println("[2]Professor");
					System.out.print("\nInput the number of choice: ");
					search_Choice = input.nextInt();
				
				}
				
				input.nextLine();
				
				switch (search_Choice) {
					case 1:
						System.out.print("Search your subject:  ");
						search_Id =input.nextLine();
						SingletonDB.searchSubject(search_Id);
						break;
						
					case 2:
						System.out.print("Search your profesor: ");
						search_Id = input.nextLine();
						SingletonDB.searchProfessor(search_Id);
						break;
						
					default:
						System.out.println("Wrong input. Please try again");
						break;
				
				}
				break;
				
				case'T':
						SingletonDB.truncate();
						break;
						
				case'C':
					SubjectBuilder sb = new SubjectBuilder();
					System.out.println("Are you a regular or irregular student?");
					is_Student = input.nextLine().toUpperCase();
					
					 switch(is_Student){
					 
					 	case"REGULAR":
					 		System.out.println("Regular Student Subjects");
							SubjectList regular = sb.present_regularStudent();
							regular.showItems();System.out.println("Total Cost: " + regular.getCost());
					 		break;
						case"IRREGULAR":
					 		System.out.println("Irregular Student Subjects");
							SubjectList iregular = sb.present_iregularStudent();
							iregular.showItems();System.out.println("Total Cost: " + iregular.getCost());
					 		break;
						default:
							System.out.println("Wrong input. Please try again");
							break;
						
						}
					break;
				
				case'P':
						
						 
						 System.out.print("\nDo you want to enroll a subject? Y/N: ");
						 char userChoice = input.nextLine().toUpperCase().charAt(0);
						 
						 
						 
						 CreditBean credit = new CreditBean();
						 switch(userChoice){
						 
						 	case'Y':
						 		String searchSub;
						 		System.out.print("\nEnter your card number: ");
							     String userCard = input.nextLine();
							     System.out.print("Search your subject:  ");
								 searchSub =input.nextLine().toUpperCase();
							     credit.transaction(userCard, searchSub);
						 		break;
						 		
						 	case'N':
						 		System.out.println("\nTransaction Cancelled.");
						 		break;
						 		
						 	default:
						 		System.out.println("\nInvalid Choice, Try Again!");
						 		break;
						 }

					 break;
					 
				case 'Q':
				
						System.out.println("Program Exiting..");
						System.exit(0);
						break;
						
						 
				case 'D':
					RegularStudentCart RSC = new RegularStudentCart();
					IrregularStudentCart ISC = new IrregularStudentCart();
					System.out.println("Are you a regular or irregular student?");
					is_Student = input.nextLine().toUpperCase();
					

					 switch(is_Student){
					 
					 	case"REGULAR":
					 		System.out.println("Regular Student Subjects");
							SubjectList regular = RSC.RegularStudentCart();
							regular.showSubjects();System.out.println("Total Cost: " + regular.getCost());
					 		break;
						case"IRREGULAR":
					 		System.out.println("Irregular Student Subjects");
							SubjectList iregular = ISC.IrregularStudentCart();
							iregular.showSubjects();System.out.println("Total Cost: " + iregular.getCost());
					 		break;
						default:
							System.out.println("Wrong input. Please try again");
							break;
						
						}
						
						break;
						
		}
	}
}
