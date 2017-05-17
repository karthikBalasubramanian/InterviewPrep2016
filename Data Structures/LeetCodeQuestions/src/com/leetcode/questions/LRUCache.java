package com.leetcode.questions;
import java.util.HashMap;

class Node{
	int key;
	int value;
	Node pre;
	Node next;
	
	public Node(int key,int value){
		this.key=key;
		this.value=value;
	}
}


public class LRUCache {
	
	HashMap<Integer,Node> lruMap;
	Node head,tail;
	int capacity;
	int count;
	

    public LRUCache(int capacity) {
    	
    	this.capacity= capacity;
    	lruMap = new HashMap<Integer,Node>();
    	head = new Node(0, 0);
    	tail = new Node(0,0);
    	head.next=tail;
    	tail.pre = head;
    	head.pre=null;
    	tail.next=null;
    	count = 0;
        
    }
    
    public void deleteNode(Node node){
    	node.pre.next = node.next;
    	node.next.pre = node.pre;
    }
    
    public void addToHead(Node node){
//    	point new node's next to tail
    	node.next = head.next;
//    	 now point tail's pre to the node
    	node.next.pre = node;
//    	now point node pre to head
    	node.pre= head;
//    	 now point head next to node
    	head.next = node;
    }
    
    public int get(int key) {
    	
//    	There are two cases
//    	 when the value is in the hash map
    	
    	if(lruMap.get(key)!=null){
    		Node returnedNode = lruMap.get(key);
//    		now remove the node
    		deleteNode(returnedNode);
//    		add the same node to head
    		addToHead(returnedNode);
    	    return returnedNode.value;
    	}
    	
// 		when the value is not in hash map
    	
//    	 return -1
    	
		return -1;
        
    }
    
    public void put(int key, int value) {
//    	 two conditions
//    	if node already there in the map
    	if(lruMap.get(key)!=null){
//    	if we put the same value already in the list,
//    	then we have to remove old node from the doubly linkedlist
    	Node alreadyInMap =  lruMap.get(key);
    	alreadyInMap.value = value;
//    	 remove the existing node
    	deleteNode(alreadyInMap);
    	addToHead(alreadyInMap);
    	}
    	else{
    		Node newNode = new Node(key,value);
    		lruMap.put(key, newNode);
//    		here two conditions
//    		if the cache count is less
    		if (count<capacity){
    			count++;
    			addToHead(newNode);
    		}
//    		 or more than the constraint
    		else{
//    			remove the node previous to tail from both map and
//    			 doubly linked list
//    			 add the new node next to head
    			lruMap.remove(tail.pre.key);
    			deleteNode(tail.pre);
    			addToHead(newNode);
    		}
    	}
    }
}


