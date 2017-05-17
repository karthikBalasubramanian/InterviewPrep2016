package com.tutorials.collection;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
	
	public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        
        Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
        treeQueue.add(root);
        while(!treeQueue.isEmpty()){
            
           int length = treeQueue.size();
           
           for(int i= 0; i<length; i++){
        	   TreeNode current = treeQueue.remove();
        	   TreeNode temp = current.left;
        	   current.left =  current.right;
        	   current.right = temp;
               if(current.left!=null){
            	   treeQueue.add(current.left);
           }
               if(current.right!=null){
            	   treeQueue.add(current.right);
               }
           }
            
        }
        
        return root;
    }

}
