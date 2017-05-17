package com.tutorials.collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
public class CollectionsTutorials {
	
	
	public static void main(String[] args){
		System.out.println("Hello I am back!!!");
		Random rand= new Random();
		int min = 1;
		int max = 10;
		int [] randomNumberArrray = new int[max];
		
		for (int i =min-1; i<max; i++){
			// nextInt is normally exclusive of the top value,
		    // so add 1 to make it inclusive
			randomNumberArrray[i] = rand.nextInt((max-min)+1)+min;
		}
		
		for(int item:randomNumberArrray ){
			System.out.println(item);
		}
		
		List<String> linkedlist = new LinkedList<String>();
		linkedlist.add("Zara");
		linkedlist.add("Mahnaz");
		linkedlist.add("Ayan");
		linkedlist.add("Zara");
		
		Map<String,String> m1 = new HashMap<String,String>(); 
	      m1.put("Zara", "8");
	      m1.put("Mahnaz", "31");
	      m1.put("Ayan", "12");
	      m1.put("Daisy", "14");
	      
	      
	   Iterator it1 =  m1.entrySet().iterator();
	   while(it1.hasNext()){
		   Map.Entry<String, String> keyValuePair = (Entry<String, String>) it1.next();
		   System.out.println(keyValuePair.getKey()+""+keyValuePair.getValue());
	   }
	   ListIterator<String> it = (ListIterator<String>) linkedlist.iterator();
	   System.out.println(" LinkedList Elements");
	   while(it.hasNext()){
//		   iterate to next value
		   Object obj = it.next();
//		   System.out.println(obj.toString());
	   }
	   while(it.hasPrevious()){
//		   iterate to next value
		   Object obj = it.previous();
		   System.out.println(obj.toString());
	   }
	      System.out.println("\t" + m1);
		
//	    System.out.println("\t" + linkedlist);
	      int count[] = {34, 22,10,60,30,22};
	  Set<Integer> finalSet = new HashSet<Integer>();
	  for(int val: count){
		  finalSet.add(val);
	  }
	  Set<Integer> treeSet = new TreeSet<Integer>(finalSet);
	  System.out.println(treeSet);
	  System.out.println(((TreeSet<Integer>) treeSet).first());
	  System.out.println(((TreeSet<Integer>) treeSet).last());
		System.out.println(linkedlist.lastIndexOf("Zara"));
		
	List<LinkedList<Integer>> listOfList = new LinkedList<LinkedList<Integer>>();
	Iterator<LinkedList<Integer>> myItr = listOfList.iterator();
	while(myItr.hasNext()){
		if(myItr.next().isEmpty()){
			myItr.remove();
		}
		
	Stack<Integer> myStack = new Stack<Integer>();
	myStack.size();
	String str = new String("hello");
	
	Map<Integer,Integer> myMap = new TreeMap<Integer,Integer>();
	myMap.containsKey(0);
	for(Map.Entry<Integer, Integer> entry: myMap.entrySet()){
		entry.getValue().intValue();
	}
	
	}
		}

}
