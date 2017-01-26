package com.interview.linkedlist;

public class Node {
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
	}
	Node(){
		
	}
	@Override
	public String toString(){
		return String.valueOf(data);
	}
}
