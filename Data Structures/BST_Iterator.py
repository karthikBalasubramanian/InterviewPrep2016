#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
from binary_search_tree import Node
from binary_search_tree import BinarySearchTree
class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        
        # inorder traversal
        # bfs
        self.my_list = self.inorder_list(root)


    def inorder_list(self,root,my_list):
    	if root:
    		self.inorder_list(root.left,my_list)
    		my_list.append(root.val)
    		self.inorder_list(root.right,my_list)
    	return my_list


        
            
        

    def hasNext(self):
        """
        :rtype: bool
        """
        if self.my_list:
            return True
        else:
            return False

    def next(self):
        """
        :rtype: int
        """
        return self.my_list.pop()


b_tree = BinarySearchTree()
a_list = [4,2,6,1,3,5,7]
for i in a_list:
    root = b_tree.insert_node_in_tree(root,i)

b_iterator = BSTIterator(root)