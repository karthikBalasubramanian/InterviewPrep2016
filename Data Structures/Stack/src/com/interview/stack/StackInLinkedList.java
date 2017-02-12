package com.interview.stack;

public class StackInLinkedList {
	Node top = null;
	public void push(int data){
		Node temp = new Node(data);
		temp.next = top;
		top = temp;
		
	}
	public Node pop(){
		if(top==null) return null;
		Node poppedNode = top;
		top = top.next;
		return poppedNode;
	}
	public int getTop(){
		return top.data;
		
	}
	public boolean isEmpty(){
		if(top==null) return true;
		else return false;
	}
	public void print(){
		Node curr = top;
		while (curr!=null){
			System.out.print(curr.data+"\t");
			curr = curr.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		StackInLinkedList obj = new StackInLinkedList();
		System.out.println("is Empty? "+obj.isEmpty());
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.print();
		obj.push(4);
		obj.push(5);
		obj.push(6);
		
		obj.print();
		System.out.println("we deleted "+obj.pop().data);
		obj.print();
		System.out.println("we deleted "+obj.pop().data);
		obj.print();
		System.out.println(obj.getTop());
	}
}
