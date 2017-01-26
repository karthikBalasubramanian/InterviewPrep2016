package com.interview.linkedlist;

public class DoublyLinkedList {

	DoubleNode head;
	int totalSize = 0; 
	public DoubleNode insertInBeg(int data){
		// two situations
		//		1. if head is empty
		//		2. if head is not
		DoubleNode newNode = new DoubleNode(data);
		if(head ==null){
			head = newNode;
		}
		else{
			newNode.next =  head;
			head.prev = newNode;
			head = newNode;
		}
		totalSize++;
		return head;		
	}
	
	public void printDoublyLinkedListFromNode(DoubleNode node){
		DoubleNode curr = node;
		int whichPoint = 0;
		while(curr!=null){
			System.out.println("at position "+whichPoint+" we find "+curr.data);
			curr = curr.next;
			whichPoint++;
		}
	}
	public void reversePrintDoublyLinkedList(DoubleNode node){
		int whichPoint = 0;
		DoubleNode curr = node;
		while(curr.next!=null){
			curr = curr.next;
			whichPoint++;
		}
		while(curr!=null){
			System.out.println("at position "+whichPoint+ " we find "+curr.data);
			curr = curr.prev;
			whichPoint--;
		}
	
	}
	
	public void deleteADoubleNode(int position){
		
		// if position is less than the total size
		// traverse to the position before the actual
		// delete
		int whichPoint = 0;
		DoubleNode curr = head;
		if(position<totalSize){
			while(whichPoint<position){
				curr = curr.next;
				whichPoint++;
			}
			curr.prev.next = curr.next;
			curr.next.prev = curr.prev;
		}
		
	}
	public static void main(String[] args){
		
		DoublyLinkedList newList = new DoublyLinkedList();
		// Random random = new Random();
		for (int i = 5; i > -1; i--) {
			newList.insertInBeg(i);
		}
		System.out.println();
		System.out.println("printing straight");
		System.out.println();
		newList.printDoublyLinkedListFromNode(newList.head);
		System.out.println();
		System.out.println("printing reverse");
		System.out.println();
		newList.reversePrintDoublyLinkedList(newList.head);
		System.out.println();
		System.out.println("after deleting a node at position 3");
		System.out.println();
		newList.deleteADoubleNode(3);
		newList.printDoublyLinkedListFromNode(newList.head);
		
	}
}
