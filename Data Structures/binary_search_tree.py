#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

import random
class Node:
    def __init__(self,val):
        self.data = val
        self.left = None
        self.right = None




class BinarySearchTree:

    def insert_node_in_tree(self,root,val):


        if root is None:
            root  = Node(val)
        elif(root.data >= val):
            root.left = self.insert_node_in_tree(root.left,val)
        else:
            root.right = self.insert_node_in_tree(root.right,val)

        return root


    def search_in_b_tree(self,root,val):
        if not root:
            return False
        else:
            if (root.data== val):
                return True
            elif(root.data<val):
                return self.search_in_b_tree(root.right,val)
            else:
                return self.search_in_b_tree(root.left,val)

    def preorder_traversal(self,root):
        if root:
            print root.data
            self.preorder_traversal(root.left)
            self.preorder_traversal(root.right)
        else:
            return

    def postorder_traversal(self,root):
        if root:
            self.postorder_traversal(root.left)
            self.postorder_traversal(root.right)
            print root.data

    def inorder_traversal(self,root):
        if root:
            self.inorder_traversal(root.left)
            
            print (root.data)
            
            self.inorder_traversal(root.right)
            
        
    def print_tree(self,root):
        if not root:
            print "done"
            return
        else:
            print ("{0},{1},{2}".format(root.data,self.print_tree(root.left),self.print_tree(root.right)))

    def level_order(self,root):
        if not root:
            return []
        else:
            final_list = []
            queue = []
            queue.append(root)
            while queue:
                current_list = []
                length = len(queue)
                for i in range(length):
                    current_root = queue.pop(0)
                    if(current_root.left):
                        queue.append(current_root.left)
                    if(current_root.right):
                        queue.append(current_root.right)
                
                    current_list.append(current_root.data)
                
                final_list.append(current_list)

            return final_list

    def invertTree(self, root):

        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        final_list = []
        if root:
            queue = []
            queue.append(root)
            
            while(queue):
                length = len(queue)
                append_list = []
                for i in range(length):
                    current_root = queue.pop(0)
                    
                    temp = current_root.left
                    current_root.left = current_root.right
                    current_root.right =  temp
                    
                    if(current_root.left):
                        queue.append(current_root.left)
                    
                    if(current_root.right):
                        queue.append(current_root.right)
                    
                    append_list.append(current_root.data)
                final_list.append(append_list)
            return final_list
        else:
            return []


    def find_path_to_value(self,root,value):
        
        if not root:
            return []
        else:
            
            path_list = []
            current_root = root
            while(current_root):
                path_list.append(current_root.data)
                if value<current_root.data:
                    current_root = current_root.left
                elif value>current_root.data:
                    current_root = current_root.right
                elif value==current_root.data:
                    break

            return path_list

    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if not root:
            return -1
        else:
            find_path_of_p = self.find_path_to_value(root,p)
            find_path_of_q = self.find_path_to_value(root,q)
            if not find_path_of_p and not find_path_of_q:
                return p

            else:
                length  = min(len(find_path_of_p),len(find_path_of_q))
                lowest = -1
                for i in range(length):
                    if(find_path_of_p[i]==find_path_of_q[i]):
                        lowest =  find_path_of_p[i]
                return lowest

    def lowestCommonAncestor_2(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if not root:
            return None
        if(root.data==p.data or root.data==q.data):
            return root
        left = self.lowestCommonAncestor_2(root.left,p,q)
        right = self.lowestCommonAncestor_2(root.right,p,q)
        print type(left)
        if (left and right):
            return root
        if (not left and not right):
            return None
        return left if left!=None else right

    def inOrderlist(self,root,my_list):

        if root:
            self.inOrderlist(root.left,my_list)
            my_list.append(root.data)
            self.inOrderlist(root.right,my_list)

        return my_list

    def findMin(self,root):
        while(root and root.left):
            root = root.left
        return root.left
    
    def deleteNode(self,root,val):

        if not root:
            return None
        elif val<root.data:
            #  this means the the value which we want to delete might be in the left sub tree
            root.left = self.deleteNode(root.left,val)
        elif val>root.right:
            #  this means the value which we want to delete will be in the right sub tree

            root.right = self.deleteNode(root.right,val)
        else:
            if(not root.left and not root.right):
                root = None
                
            elif (not root.right):
                root = root.left
                
            elif (not root.left):
                root = root.right
            else:
                next_head = root.right
                while(right and right.left):
                    next_head = next_head.left
                next_head.lefet = root.left
                return root.right
        return root


    def inorderSuccessor(self,root):
        
            


b_tree = BinarySearchTree()
root = None
a_list = [4,2,6,1,3,5,7] 

# random.shuffle(a_list)
print a_list
for i in a_list:
    root = b_tree.insert_node_in_tree(root,i)
a =random.choice(a_list)
print b_tree.search_in_b_tree(root,a)
b_tree.preorder_traversal(root)
print 
b_tree.postorder_traversal(root)
print
b_tree.inorder_traversal(root)
print 
b_tree.print_tree(root)
print 
# print b_tree.level_order(root)
# print 
# # print b_tree.invertTree(root)
# print b_tree.lowestCommonAncestor(root,1,6)
# p = Node(6)
# q = Node(7)
# print b_tree.lowestCommonAncestor_2(root,p,q).data
print b_tree.inOrderlist(root,[])
print 
# print b_tree.deleteNode(root,7)
print 
print b_tree.level_order(root)
print b_tree.deleteNode(root,6)
print b_tree.inOrderlist(root,[])