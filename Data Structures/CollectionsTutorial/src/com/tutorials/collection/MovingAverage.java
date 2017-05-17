package com.tutorials.collection;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
	
	private double previousSum = 0.0;
	private int maxSize;
	private Queue<Integer> movingQueue;
	MovingAverage(int capacity){
		movingQueue = new LinkedList<Integer>();
		maxSize=capacity;

}
	public double next(int val){
		if(movingQueue.size()==maxSize){
			previousSum-=movingQueue.remove();
			
		}
		previousSum+=val;
		movingQueue.add(val);
		return previousSum/movingQueue.size();
	}
	
}

