#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


class BinaryTree:
	
	def __init__(self,rootObj):
		self.root = rootObj
		self.leftChild = None
		self.rightChild = None

	def insertLeft(self,newNode):
		if self.leftChild == None:
			self.leftChild = BinaryTree(newNode)

		else:
			# push all the left childs below the newNode
			t = BinaryTree(newNode)
			t.leftChild = self.leftChild
			self.leftChild = t


	def insertRight(self,newNode):
		if self.rightChild == None:
			self.rightChild = BinaryTree(newNode)
		else:
			# push all the right childs below the newNode
			t = BinaryTree(newNode)
			t.rightChild = self.rightChild
			self.rightChild = t


	def getRightChild(self):
		return self.rightChild

	def getLeftChild(self):
		return self.leftChild


	def setRootVal(self,newVal):
		print newVal
		self.root = newVal

	def getRootVal(self):
		return self.root



r = BinaryTree('a')
r.setRootVal('b')
print(r.getRootVal())
print(r.getLeftChild())
r.insertLeft('b')
print(r.getLeftChild())
print(r.getLeftChild().getRootVal())
r.insertRight('c')
print(r.getRightChild())
print(r.getRightChild().getRootVal())
r.getRightChild().setRootVal('hello')
print(r.getRightChild().getRootVal())



