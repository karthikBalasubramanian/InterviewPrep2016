package com.tutorials.collection;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
//    trick in this problem is, median can be found only in the sorted list
//	 we have to sort the list each and every time a value is added in the list.
//	 that's an inefficient method. 
//	 so what info we have got? 
    
    /** initialize your data structure here. */
//	 large keep the largest half of the array
//	 small keeps the smallest half of the numbers negated. This is very important to understand
//	its easy to retrive the middle elements if the smaller half is negated and added to the priority queue
//	 because always when we peek, the largest element in the smaller half when negated becomes the smallest element.
	private Queue<Long> small = new PriorityQueue(),
            large = new PriorityQueue();

    
    public void addNum(int num) {
//    	 initially add
    	large.add((long)num);
//    	remove the least from the large heap
    	small.add(-large.poll());
    	if(large.size()<small.size())
    		large.add(-small.poll());
    
        
    }
    
    public double findMedian() {
    	return large.size()>small.size()?large.peek():(large.peek()-small.peek())/2.0;
        
    }
    
    
    	public static void main(String[] args){
//    		PriorityQueue<Integer> howThisWorks = new PriorityQueue<Integer>();
//    		howThisWorks.add(3);
//    		howThisWorks.add(1);
//    		System.out.println(howThisWorks.peek());
//    		howThisWorks.add(4);
//    		
//    		System.out.println(howThisWorks.peek());
//    		System.out.println(-howThisWorks.peek());
//    		System.out.println(howThisWorks);
    		MedianFinder obj = new MedianFinder();
    		for(int i=1; i<=7;i++){
    			obj.addNum(i);
    		}
    		
    		System.out.println(obj.findMedian());
    	}
}