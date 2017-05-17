package com.interview.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class AllSorts {

	
	public void insertionSort(int[] array){
		
//		 maintains sorted sublist from beginning of the list to the
//		pointer position
		for (int i=1; i<array.length; i++){
			for(int j = i ; j > 0 ; j--){
				if(array[j]<array[j-1]){
					swap(array,j,j-1);
				}
			}
			
//			array[current_pos] =  current_val;
		}
		
		
	}
	
	public void selectionSort(int[] array){
//		super simple. Same as bubble sort. 
//		but does not swap for each and every comparison.

		for (int i= array.length-1;i>0;i--){
			int positionOfMax = 0;
			for(int j=0; j<=i; j++){
				
				if(array[j]>array[positionOfMax]){
					positionOfMax =  j;
				}
			
			}
			swap(array,i,positionOfMax);
		}
		
	}
	
	public void nextNearestPredecessor(int[] array){
		Stack<Integer> stack = new Stack<Integer>();
		System.out.print("next nearest\t");
		for (int i=0; i<array.length; i++){
			while(!stack.isEmpty() && stack.peek()>array[i]){
				stack.pop();
			}
			if(stack.isEmpty()){
				System.out.format("%s\t",'_');
			}
			else{
				System.out.format("%d\t",stack.peek());
			}
			
			stack.push(array[i]);	
		}
	}
	
	public void bubbleSort(int[] array){
//		each item bubbles up to the location where it belongs
//		compares adjacent elements and swaps if the they are out of place
//		start from end of the list to 0
		for (int i = array.length-1; i>=0; i--){
			for (int j=0;j<i; j++){
				if (array[j]>array[j+1]){
					swap(array,j,j+1);
				}
			}
		}
	}
	
	
	public int[] quickSort(int[] array){
		return null;
	}
	
	public int[] mergeSort(int[] array){
		return null;
	}
	
	public void shuffle(int[] array){
		
		int length =  array.length;
		Random random = new Random();
		
		for(int i =0; i<length; i++){
			int randomPos =  i+random.nextInt(length-i);
			swap(array,i,randomPos);
		}
		
	}
	
	public void swap(int[]array, int posi,int posj){
		int temp = array[posi];
		array[posi] = array[posj];
		array[posj]= temp;
	}
	
	public void print(String funcType,int[]numbers){
		String format = "%d\t";
		System.out.println();
		System.out.print(funcType+":\t");
		for(int i=0; i<numbers.length; i++){
			System.out.format(format,numbers[i]);
		}
	}
	
	
	public static void main(String [] args){
		int[] numbers = new int[10];
		for(int i=0; i<10; i++){
			numbers[i]=i+1;
		}
		AllSorts sortobj = new AllSorts();
		sortobj.print("unshuffled list", numbers);
		sortobj.shuffle(numbers);
		sortobj.print("shuffled list", numbers);
		sortobj.bubbleSort(numbers);
		sortobj.print("bubble sort",numbers);
		sortobj.shuffle(numbers);
		sortobj.print("shuffled again", numbers);
		sortobj.selectionSort(numbers);
		sortobj.print("selection sort", numbers);
		sortobj.shuffle(numbers);
		sortobj.print("shuffled again", numbers);
		sortobj.insertionSort(numbers);
		sortobj.print("insertion sort", numbers);
		sortobj.shuffle(numbers);
		sortobj.print("shuffled again", numbers);
		System.out.println();
		sortobj.nextNearestPredecessor(numbers);
		String val = "Hello";
		System.out.println();
		char[] arr = val.toLowerCase().toCharArray();
		Arrays.sort(arr);
		System.out.println(new String(arr));
		
		
		
		
		
	}
}
