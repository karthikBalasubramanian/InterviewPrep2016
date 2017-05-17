package com.tutorials.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LowestCommonPrefix {
	
	public HashSet<Character> getAllChars(String word){
		HashSet<Character> myWordHashSet = new HashSet<Character>();
		int length = word.length();
		for(int i=0; i<length; i++){
			myWordHashSet.add(word.charAt(i));	
		}
		return myWordHashSet;	
	}
	
	
	public String returnMatchingChars(char[] firstCharArray, char[] subsequentCharArray){
		
		int lengthFirst = firstCharArray.length-1;
		int lengthSecond = subsequentCharArray.length-1;
		StringBuilder characterList = new StringBuilder(); 
		for(int i=0,j=0; i<=lengthFirst&&j<=lengthSecond;i++,j++){
			if(firstCharArray[i]!=subsequentCharArray[j]){
				break;
			}
			characterList.append(firstCharArray[i]);
			
		}
		
		
		return characterList.toString();
	}
	
	
	
	 public String longestCommonPrefix(String[] strs) {
		 
		 	if(strs.length>1){
		 		char[] firstWord =  strs[0].toCharArray();
		 		for(int i=1; i<strs.length; i++){
		 			char[] subsequentWord = strs[i].toCharArray();
		 			System.out.println(firstWord);
		 			System.out.println(subsequentWord);
		 			firstWord = returnMatchingChars(firstWord,subsequentWord).toCharArray();
		 			
		 		}
		 		
		 		
		 		return new String(firstWord);
		 	}
		 	else{
		 		return strs[0];
		 	}
		 
		 
	        
	 }
	 
	 
	 
	 
	 
	 public static void main(String[] args){
		 String s= new String("Ankit");
		 String s2 = "Ankit";
		 s ="Karthik";
		 System.out.println(s);
		 //System.out.println(s2==s);
		 System.out.println(s2);
		 
		 
		 String[] myString  = s.split("\\s+");
		 for(String eachStr:myString){
			 System.out.println(eachStr);
		 }
		 List<String> strCollection = Arrays.asList(myString);
		 Collections.reverse(strCollection);
		 String joined = String.join(" ", strCollection);
		 System.out.println(joined);
		 LowestCommonPrefix	obj = new LowestCommonPrefix();
		 String [] array = {"geeksforgeeks","geeks","geek","gee"};
		 System.out.println(obj.longestCommonPrefix(array));
	 }

}
