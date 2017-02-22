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
	
	public boolean isBinarySearchTree(BstNode root, int minValue,int maxValue){
		if(root==null){
			return true;
		}
		if(root.data>=minValue&&root.data<maxValue && isBinarySearchTree(root.left, minValue, root.data)&&isBinarySearchTree(root.right, root.data, maxValue)){
			return true;
		}else{
			return false;
		}

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
	
	public boolean binarySearchTreeCheckUtil(BstNode root,int min,int max){
		if(root==null){
			return true;
		}
		if((root.data>=min)&&(root.data<max)&&binarySearchTreeCheckUtil(root.left, min, root.data)
				&& binarySearchTreeCheckUtil(root.right, root.data, max)){
			return true;
		}else{
			return false;
		}
		
	}
	
	public boolean checkIfBinarySearchTree(BstNode root){
		return binarySearchTreeCheckUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
	
//	 binary search tree deletion
	
	public BstNode deleteNode(BstNode root,int data){
		System.out.println("data to delete"+data);
		if(root==null){
			System.out.println("inside root.data==null");
			return null;
			
		}
		
		
//		First search for the data
		else if(data>root.data){
			root.right = deleteNode(root.right, data);
		}
		else if(data<root.data){
			root.left = deleteNode(root.left, data);
		}else if(root.data==data){
			//we have found data/node. Now what?
//			how to delete node?
//			If node does not have any child?
			if(root.left==null&&root.right==null){
				root = null;
			}
//			if node has only one child?
			else if(root.left==null){
				root = root.right;
			}
			else if(root.right==null){
				root =  root.left;
			}
//			if node has two child? search the max of left node or min of right node
			else {
				int minAtRight = findMin(root.right);
				System.out.println("min value in right tree is "+ minAtRight);
				BstNode temp = new BstNode(minAtRight);
				root.data = temp.data;
//				search the duplicated data in root at right, and remove the node. adjust the right
//				which is the deleted node's nearest head.
				root.right =  deleteNode(root.right, temp.data);
			}
			
		}
		
		
		
		return root;
	}
	
	public BstNode findNode(BstNode root,int data){
		if (root==null){
			return null;
		}
		if(root.data==data){
			return root;
		}
		else if(data<= root.data){
			return findNode(root.left, data); 
		}else{
			return findNode(root.right, data);
		}
	}
	
	public void inOrderSuccessor(BstNode root,int whoseSuccessor){
//		This function is to identify the inorder successor of an integer.
		BstNode getPredicessor = findNode(root, whoseSuccessor);
		if(getPredicessor== null){
			System.out.println("sorry the data is not found in the tree.\n cant find predicessor");
		}
//		successor is the deepest parent for whom the child node is on the left side.
//		run through the tree from root to the getPredicissor node.
//		then  keep updating successor data if get predicissor's data is less than current data
//		else move to the right.
		else{
			BstNode current = root;
			BstNode successor = null;
			while(getPredicessor.data!=current.data){
				if(getPredicessor.data<current.data){
					successor = current;
					current = current.left;
				}else{
					current = current.right;
				}
			}
			
			System.out.println("sucessor for node with value "+getPredicessor.data+" is "+successor.data);
			
		}
	}
	
	public boolean isBalanced(BstNode root) {
        
		if(root==null){
            return true;
        }else{
        	System.out.println("left height"+ getHeight(root.left));
        	System.out.println("right height "+ getHeight(root.right));
        	if (java.lang.Math.abs(getHeight(root.left)-getHeight(root.right))<=1&&isBalanced(root.left)&& isBalanced(root.right)){
        		return true;
        	}
        	else return false;
            
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
		
		System.out.println("\nCheck for binary tree");
		System.out.println("is binary tree? "+ treeObj.checkIfBinarySearchTree(root));
		System.out.println();
		System.out.println("Minimimum value in tree is "+ treeObj.findMin(root));
		System.out.println();
		System.out.println("Maximum value in tree is "+treeObj.findMax(root));
		System.out.println();
		System.out.println("Finding height of the node");
		// remember height of a root node is same as maximum depth from leaf
		System.out.println("height of the tree is "+ treeObj.getHeight(root));
		
		System.out.println("\n is balanced?"+treeObj.isBalanced(root));
		
		System.out.println("\n get successor for inorder traversal");
		treeObj.inOrderSuccessor(root, 39);
		System.out.println();
		int[] levelOrder = new int[]{12,5,15,3,7,13,17,1,9};
		root = null;
		System.out.println();
		System.out.println("doing level order or breadth first search!");
		for(int i=0; i<levelOrder.length; i++){
			root = treeObj.insertNodeInTree(root, levelOrder[i]);
		}
//		deleting a node before printing level order
		
		System.out.println();
		System.out.println("printing started\n");

		treeObj.getLevelOrder(root);
		
		System.out.println("\ndeleting node with data 15");
		root = treeObj.deleteNode(root, 15);			
		System.out.println("\ncheck if tree is adjusted");
		treeObj.getLevelOrder(root);
		System.out.println("\ndepth first search\n");

		System.out.println("1. pre-order print\n");
		treeObj.preOrderPrint(root);
		System.out.println("\n2.in-order print\n");
		treeObj.inOrderPrint(root);
		System.out.println("\n3.post-order print\n");
		treeObj.postOrderPrint(root);
		
		
	}

}
