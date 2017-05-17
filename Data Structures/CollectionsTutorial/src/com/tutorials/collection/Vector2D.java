package com.tutorials.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vector2D {
	
	Iterator<ArrayList<Integer>> listItr;
	Iterator<Integer> integerItr;
	
	public Vector2D(List<ArrayList<Integer>> vec2d) {
		// TODO Auto-generated constructor stub
		if(vec2d!=null || vec2d.size()>=0){
//			 next row
			listItr = vec2d.iterator();
//			next element
			integerItr = listItr.next().iterator();
		}
		
	}
	
	public void getNextRow(){
//		 get next row only is the current row is empty
//		 and list iterator has next iterator object
		if(!integerItr.hasNext() && listItr.hasNext()){
			integerItr = listItr.next().iterator();
		}
	}

	public int next(){
		int next =  integerItr.next();
		getNextRow();
		return next;
	}
	
	public boolean hasNext(){
		return integerItr!=null && integerItr.hasNext();
		
		
	}
	public static void main(String [] args){
		List<ArrayList<Integer>> vec2d =  new ArrayList<ArrayList<Integer>>();
		int counter=1;
		
		for (int i=0; i<=2; i++){
			ArrayList<Integer> current =  new ArrayList<Integer>();
			for(int j=0;j<=2; j++){
				current.add(counter);
				counter+=1;
			}
			vec2d.add(current);
		}
		
//		Iterator<ArrayList<Integer>> listItr = vec2d.iterator();
//		Iterator<Integer> intItr = listItr.next().iterator();
//		 while(!intItr.hasNext() && listItr.hasNext()){
//			 System.out.println(intItr.next());
//			 
//		 }
		
		Vector2D i = new Vector2D(vec2d);
		while (i.hasNext()) System.out.println(i.next());
			

		
	}
	
}
