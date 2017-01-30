package com.interview.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;


public class Trees {
	
	int treeSize = 0;
	
	public BstNode insertNodeInTree(BstNode root,int data){
		
		// three important scenarios
		// what if root is null
		// what if data is <= root.data
		// what if data is greater than root.data
		
		
		if(root == null){
			root = new BstNode(data);
		}else if(root.data>=data){
			root.left = insertNodeInTree(root.left, data);
		}else{
			root.right = insertNodeInTree(root.right, data);
		}
			
		treeSize++;
		return root;
		
	}
	
	public boolean SearchDataInTree(BstNode root,int data){
		if(root == null){
			return false;
		}
		if(root.data == data){
			return true;
		}else if(root.data>=data){
			return SearchDataInTree(root.left, data);
		}else{
			return SearchDataInTree(root.right, data);
		}
		
	}
	
	public int findMin(BstNode root){
		// assuming that the node wont be empty.
		if(root.left == null){
			return root.data;
		}else{
			return findMin(root.left);
		}
	}
	public int findMax(BstNode root){
		// assuming that the node wont be empty.
		if(root.right == null){
			return root.data;
		}else{
			return findMax(root.right);
		}
	}
	
	public void getLevelOrder(BstNode root){
		if(root == null){
			return;
		}
		// very simple implementation of breadth first search
		// 1. visit a node and put into a queue
		// 2.  pop it/ remove it. print dat in it 
		// 3. check if there are left nodes, if yes add to the queue
		// 4. check there are right nodes, if yes add to the queue
		// 5. run this until your queue is empty
		// Time complexity O(n) as you are visiting all the nodes atleast once
		// space complexity is proportional to O(n) worst/average case 
		Queue<BstNode> queueLevel = new LinkedList<BstNode>();
		queueLevel.add(root);
		while(!queueLevel.isEmpty()){
			BstNode removedNode = queueLevel.remove();
			System.out.print(removedNode.data+"\t");
			if(removedNode.left!=null){
				queueLevel.add(removedNode.left);
			}
			if(removedNode.right!=null){
				queueLevel.add(removedNode.right);
			}
			
		}
	}
	
	public void preOrderPrint(BstNode root){
		// very simple. Data -> left -> right
		// visit/print data first.
		// goto left
		// then go to right
		// if node is empty return
		
		if(root == null){
			return;
		}
		System.out.print(root.data+"\t");
		preOrderPrint(root.left);
		preOrderPrint(root.right);
	}
	
	// we will get sorted print values for in order
	public void inOrderPrint(BstNode root){
		if(root == null){
			return;
		}
		// very simple left -> Data - > right
		// got to left
		// print data
		// got to right
		
		inOrderPrint(root.left);
		System.out.print(root.data + "\t");
		inOrderPrint(root.right);
		
	}
	
	public void postOrderPrint(BstNode root){
		if(root==null){
			return;
		}
		// very simple left -> right - > Data
		// got to left
		// goto right
		// print root
		
		postOrderPrint(root.left);
		postOrderPrint(root.right);
		System.out.print(root.data+"\t");
	}
	
	public int getHeight(BstNode root){
		if(root == null){
			// why -1? the height of a leaf node is 0. it has node.left and node.right
			// both null. if you give return 0, max(0,0) +1 becomes 1
			// which is not the case. so return -1
			// max(-1,-1)+1 = 0.
			return -1;
		}else{
			return java.lang.Math.max(getHeight(root.left),getHeight(root.right))+1;
		}
	}
	
	public static void main(String[] args){
		
		Trees treeObj = new Trees();
		BstNode root = null;
		
		Random myRandom = new Random(1);
		int[] generator = myRandom.ints(1,50).distinct().limit(10).toArray();

		for (int i = 0; i < generator.length; i++) {
			root = treeObj.insertNodeInTree(root, generator[i]);
			System.out.println("item "+ generator[i] + " got inserted");
		}

		System.out.println();
		System.out.println("enter the number to search in tree\n");
		Scanner myScanner = new Scanner(System.in);;
		while(true){
			
			while(!myScanner.hasNextInt()){
				System.out.println("sorry enter a number");
				myScanner = new Scanner(System.in);
			}
			int data = myScanner.nextInt();
			if(treeObj.SearchDataInTree(root, data)){
				System.out.println("the number "+data+" is found!");
				System.out.println("thanks for playing this search game");
				break;
				
			}else{
				System.out.println("sorry try again! Number is not in tree");
			}
		}
		
		System.out.println();
		System.out.println("Minimimum value in tree is "+ treeObj.findMin(root));
		System.out.println();
		System.out.println("Maximum value in tree is "+treeObj.findMax(root));
		System.out.println();
		System.out.println("Finding height of the node");
		// remember height of a root node is same as maximum depth from leaf
		System.out.println("height of the tree is "+ treeObj.getHeight(root));
		
		int[] levelOrder = new int[]{4,2,5,1,3,6,7};
		root = null;
		System.out.println();
		System.out.println("doing level order or breadth first search!");
		for(int i=0; i<levelOrder.length; i++){
			root = treeObj.insertNodeInTree(root, levelOrder[i]);
		}
		
		System.out.println();
		System.out.println("printing started\n");

		treeObj.getLevelOrder(root);
		System.out.println();
		System.out.println("depth first search\n");

		System.out.println("1. pre-order print\n");
		treeObj.preOrderPrint(root);
		System.out.println("\n2.in-order print\n");
		treeObj.inOrderPrint(root);
		System.out.println("\n3.post-order print\n");
		treeObj.postOrderPrint(root);
		
	}

}
