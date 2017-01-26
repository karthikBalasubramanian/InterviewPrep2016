package com.interview.linkedlist;

public class DoubleNode {
	
	DoubleNode prev;
	DoubleNode next;
	int data;
	
	DoubleNode(){
		
	}
	
	DoubleNode(int data){
		this.data =data;
	}
	
	@Override
	public String toString(){
		return String.valueOf(data);
	}

}
