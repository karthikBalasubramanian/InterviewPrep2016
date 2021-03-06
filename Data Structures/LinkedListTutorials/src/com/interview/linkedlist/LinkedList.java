package com.interview.linkedlist;
public class LinkedList {

	// Example implementation of Singly linked list
	// which is like
	// head -> Node(10) -> Node(5) -> Node(16) -> Node(12) -> Null
	// Follows last in first out
	// Real world example https://en.wikipedia.org/wiki/Conga_line
	// Major Operations:
	// 1. add to linked list
	// 2. insert
	// 1 a. insert in the beginning
	// 1 b. insert in a position
	// 3. find
	// 4. delete
	// 5. print the elements in linked list
	// never change head or tail node.
	// Always use a proxy node for search and delete operations

	Node head = null;
	Node tail = null;
	int totalSize = 0;

	public void add(int data) {
		// Situations
		// add to an empty linked list
		// add to a non-empty linked list
		Node node = new Node(data);

		// empty linked list
		if (tail == null) {
			head = node;
			tail = node;
		}
		// here we cover the situation of adding to end of list
		else {
			tail.next = node;
			tail = node;
		}
		totalSize++;

	}

	public void insertInBeg(int data) {
		// inserting to the
		Node node = new Node(data);
		node.next = head;
		head = node;
		totalSize++;
	}

	public void insertInPos(int data, int position) {
		// if position exceeds totalSize insert at end with warning
		if (position > totalSize) {
			System.out.println("position " + position + " is greater than total size of " + totalSize);
			System.out.println("So adding data " + data + "  at the end");
			Node lastNode = new Node(data);
			tail.next = lastNode;
			tail = lastNode;
			if (totalSize == 0) {
				head = lastNode;
			}

		} else {
			Node prev = null;
			Node curr = head;
			int i = 0;
			while (i < position) {
				prev = curr;
				curr = curr.next;
				i++;
			}
			Node insertNode = new Node(data);
			prev.next = insertNode;
			insertNode.next = curr;

		}
		totalSize++;
	}
	
	

	public Node delete(int data) {
		// Situations
		// first get the position of the data and then delete
		// then delete from the position. same as insert with small difference

		Node prev = null;
		Node curr = head;
		int i = 0;
		int positionToDelete = getPositionForData(data);
		if (positionToDelete == -1) {
			return null;
		} else {
			while (i < positionToDelete) {
				prev = curr;
				curr = curr.next;
				i++;
			}
			if (prev == null) {
				head = curr.next;

			} else {
				prev.next = curr.next;

			}
			return curr;
		}

	}

	public int getPositionForData(int data) {
		int i = -1;
		Node curr = head;
		while (curr != null) {
			i++;
			if (curr.data == data) {
				return i;
			}
			curr = curr.next;
		}
		return -1;
	}

	public void display(Node displayHead) {
		if (displayHead == null) {
			System.out.println("the list is empty");
		} else {
			Node curr = displayHead;
			int i = 0;
			while (curr != null) {
				System.out.println("position " + String.valueOf(i) + " has data " + String.valueOf(curr.data));
				i++;
				curr = curr.next;
			}
		}
	}

	

	public Node find(int data) {
		// Scenarios: 1. if linked list is empty
		// if data is in the head
		// if data is not in the head
		if (tail == null) {
			return null;
		} else if (head.data == data) {
			return head;
		} else {

			Node searchNode = head;

			while (searchNode.next != null) {

				searchNode = searchNode.next;
				if (searchNode.data == data) {
					return searchNode;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		LinkedList newList = new LinkedList();
		// Random random = new Random();
		for (int i = 0; i <= 5; i++) {
			newList.add(i);
		}
		newList.display(newList.head);
		System.out.println();
		System.out.println("Inserting in the beginning");
		newList.insertInBeg(-1);
		newList.display(newList.head);
		System.out.println();
		System.out.println("inserting in a position 2");
		newList.insertInPos(10, 2);
		newList.display(newList.head);
		System.out.println();
		System.out.println("inserting in position larger than size");
		newList.insertInPos(1, 1000);
		newList.display(newList.head);
		System.out.println();
		System.out.println("Deleting");
		Node deletedNode = newList.delete(-1);
		if (deletedNode == null) {
			System.out.println("Sorry data not there in linkedlist");
		} else {
			System.out.println("Deleted node's data is " + deletedNode.data);
		}
		System.out.println();
		newList.display(newList.head);
		System.out.println();

	}
}
