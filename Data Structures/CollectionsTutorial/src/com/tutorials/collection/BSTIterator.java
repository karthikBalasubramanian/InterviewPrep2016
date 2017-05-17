package com.tutorials.collection;

import java.util.Stack;

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) 
      { val = x; }
  }

public class BSTIterator {
	TreeNode current=null;
	Stack<TreeNode> myStack;
    public BSTIterator(TreeNode root) {
        current = root;
        myStack = new Stack<TreeNode>();
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
		return (!myStack.isEmpty()) || (current!=null);
        
    }

    /** @return the next smallest number */
    public int next() {
		while(current!=null){
			myStack.add(current);
			current = current.left;
		}
		
		TreeNode return_node = myStack.pop();
		int return_value = return_node.val;
		current = return_node.right;
		
		return return_value;
		
        
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */