package com.iac.builder;

import java.util.ArrayList;
import java.util.List;


public class SubjectList {

	private List<Item> items = new ArrayList<Item>();	

	   public void addItem(Item item){
	      items.add(item);
	   }

	   public double getCost(){
	      double cost = 0.0;
	      
	      for (Item item : items) {
	         cost += item.price();
	      }		
	      return cost;
	   }

	   public void showItems(){
	      for (Item item : items) {
	         System.out.print("Item : " + item.name());
	         System.out.print(", Packing : " + item.pack().pack());
	         System.out.println(", Price : " + item.price());
	      }	
	   }
	      public void showSubjects(){
		      for (Item item : items) {
		         System.out.print( item.name() + " ");
		         System.out.println(", Price:  " +item.price()+" ");
		      }		
	   }	
}
