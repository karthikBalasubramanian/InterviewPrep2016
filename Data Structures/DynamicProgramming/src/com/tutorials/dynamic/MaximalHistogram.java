package com.tutorials.dynamic;

import java.util.PriorityQueue;
import java.util.Stack;


public class MaximalHistogram {
	
	 public static int largestRectangleArea(int[] heights) {
	       
		 Stack<Integer> positionStack  = new Stack<Integer>();
		 int currentArea = 0;
		 int maxArea = Integer.MIN_VALUE;
		 int i;
		 
		 for(i=0; i<=heights.length; i++){
			 
			 int value = (i==heights.length)?0:heights[i];
			 if(positionStack.isEmpty() || heights[positionStack.peek()] <= value){
				 positionStack.push(i);
			 }
			 else{
				 int removedIndex =  positionStack.pop();
				 if(positionStack.isEmpty()){
					 currentArea =  heights[removedIndex]*i;
				 }
				 else{
					 currentArea =  heights[removedIndex]*(i-positionStack.peek()-1);
				 }
				 
				 maxArea = Math.max(maxArea, currentArea);
//				 Trick here is to avoid another for loop
				 i--;
			 }
		 }
		 
		 
		 
		 return maxArea;
	    }
	 
	 public int maximalRectangle(char[][] matrix) {
		 int maxValue = Integer.MIN_VALUE;
		 
		 int[] traversingArray = new int[matrix[0].length];
		 for(int i=0; i<matrix.length; i++){
			 for(int j=0; j<matrix[0].length; j++){
				 int value = Integer.parseInt(String.valueOf(matrix[i][j]));
				 if(value==0){
					 traversingArray[j]=0;
				 }else{
					 traversingArray[j]+=value;
				 }
			 }
			 
			 maxValue = Math.max(maxValue, largestRectangleArea(traversingArray));
			 
			 
		 }
		return maxValue;
	        
	    }
	 
	 
	 public static void main(String[] args){
		 int[] array = {3,2,1,5,6,4};
		 System.out.println(largestRectangleArea(array));
		 
		 PriorityQueue<Integer> myQueue = new PriorityQueue<Integer>();
		 
		 for(int i=0; i<array.length; i++){
	            myQueue.add(array[i]);
	        }
		 
		 for(int i: myQueue){
			 System.out.println(i);
		 }
		 
	 }

}
