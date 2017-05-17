package com.tutorials.collection;

public class MajorityElement {
	public static int findMajorityElement(int[] arr, int size) { 
	    int count = 0, i, majorityElement=0;
	    for (i = 0; i < size; i++) {
	        if (count == 0)
	            majorityElement = arr[i];
	        if (arr[i] == majorityElement) 
	            count++;
	        else
	            count--;
	    }
	    count = 0;
	    for (i = 0; i < size; i++)
	        if (arr[i] == majorityElement)
	            count++;
	    if (count > size/2)
	        return majorityElement;
	    return -1;
	}
	
	public static void main(String[] args){
		
		int[] array = new int[1];
		System.out.println(findMajorityElement(array, 1));
	}

}
