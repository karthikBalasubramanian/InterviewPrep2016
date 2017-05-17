package com.tutorials.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class Permutation {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> finalResult = new ArrayList<List<Integer>>();
		List<Integer> currentList = new ArrayList<Integer>();
		Arrays.sort(nums);
		permuteUtil(nums, currentList, finalResult);
		
		return finalResult;
	}
	
	
	public void permuteUtil(int[] nums, List<Integer> currentResult, List<List<Integer>>resultList){
		if(currentResult.size()==nums.length){
			resultList.add((new ArrayList<Integer>(currentResult)));
			return;
		}
		
		for(int i=0;i<nums.length; i++){
			if(currentResult.contains(nums[i])){
				continue;
			}
			currentResult.add(nums[i]);
			System.out.println("current result before removing "+ currentResult+" and i value is "+ i);
			permuteUtil(nums, currentResult, resultList);
			
			currentResult.remove(currentResult.size()-1);
			System.out.println("current result after removing "+ currentResult+" and i value is "+ i+"\n");
		}
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
        
		Map<Integer,Integer> sortedUniqueCount = new TreeMap<Integer,Integer>();
		for(int val: nums){
			
			if(sortedUniqueCount.containsKey(val)){
				sortedUniqueCount.put(val, sortedUniqueCount.get(val)+1);
			}else{
				sortedUniqueCount.put(val, 1);
			}
		}
		
		Integer[] uniqueKeys = sortedUniqueCount.keySet().toArray(new Integer[sortedUniqueCount.keySet().size()]);
		Integer[] values = sortedUniqueCount.values().toArray(new Integer[sortedUniqueCount.values().size()]);
		
		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
		Integer[] currentList = new Integer[nums.length];
		permuteUniqueUtil(currentList,finalList,0,uniqueKeys,values);
		
		
		return finalList;
    }
	
	
	public void permuteUniqueUtil(Integer[] currentList, List<List<Integer>> finalList,int level, Integer[] uniqueKeys,Integer[] uniqueValues){
		
		if(level==currentList.length){
			finalList.add(new ArrayList<Integer>(Arrays.asList(currentList)));
			return;
		}
		
		for(int i=0; i<uniqueKeys.length; i++){
			if(uniqueValues[i]==0){
				continue;
			}
			
			currentList[level]= uniqueKeys[i];
			uniqueValues[i]--;
			permuteUniqueUtil(currentList,finalList,level+1,uniqueKeys,uniqueValues);
			uniqueValues[i]++;
			
		}
		
		
	}
	
	public boolean canPermutePalindrome(String s) {
        
		char[] charArray = s.toCharArray();
		Map<Character,Integer> finalMap = new TreeMap<Character,Integer>();
		for(char c: charArray){
			if (finalMap.containsKey(c)&&finalMap.get(c)==1){
				finalMap.put(c, finalMap.get(c)-1);
			}
			else if(finalMap.containsKey(c)&&finalMap.get(c)==0){
				finalMap.put(c, finalMap.get(c)+1);
			}
			else{
				finalMap.put(c, 1);
			}
		}
		
		int count=0;
		for(int val:finalMap.values()){
			count+=val;
		}
		
		if((count==0)||(count==1)){
			return true;
		}
		
		return false;
    }
	
	public static void main(String [] args){
		Map <Integer,Integer> ordinaryMap = new HashMap<Integer,Integer>();
		Map <Integer,Integer> sortedMap = new TreeMap<Integer,Integer>();
		Random random =  new Random();
		for(int i=0; i<5; i++){
			int nextVal = random.nextInt();
			if(ordinaryMap.containsKey(nextVal)){
				ordinaryMap.put(nextVal, ordinaryMap.get(nextVal)+1);
			}
			if(sortedMap.containsKey(nextVal)){
				sortedMap.put(nextVal, ordinaryMap.get(nextVal)+1);
			}
			ordinaryMap.put(nextVal, 1);
			sortedMap.put(nextVal,1);
		}
		Permutation obj = new Permutation();
		int[] nums= new int[]{1,1,2};
//		System.out.println(obj.permute(nums));
//		System.out.println(obj.permuteUnique(nums));
		System.out.println(obj.canPermutePalindrome("aab"));
	}
}
