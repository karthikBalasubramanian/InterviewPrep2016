#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

class BinaryHeap:

	def __init__(self):
		#  by default create a list with one element 0 which will be at the index 0.
		self.heapList = [0]
		self.currentSize = 0

	def insert(self,element):
		self.heapList.append(element)
		self.currentSize+=1
		self.percolateUp(self.currentSize)


	def percolateUp(self,index):
		# start from the leaf index
		while(index//2>0):
			if(self.heapList[index]<self.heapList[index//2]):
				# if the leap index is less than its parent, Swap
				temp = self.heapList[index]
				self.heapList[index] = self.heapList[index//2]
				self.heapList[index//2]=temp
			# Keep reducing the the height towards the root
			index = index//2

	def percolateDown(self,i):
		while(i*2)<=self.currentSize:
			minChild = self.minChild(i)
			if(self.heapList[i]>self.heapList[minChild]):
				temp = self.heapList[i]
				self.heapList[i] = self.heapList[minChild]
				self.heapList[minChild]=temp
			i = minChild

	def minChild(self,i):
		if i*2+1>self.currentSize:
			print i*2
			return i*2
		else:
			if self.heapList[i*2]<self.heapList[(i*2)+1]:
				return i*2
			else:
				return (i*2)+1
				

	def delMin(self):

		# returns the first value
		# in the heap list
		minVal = self.heapList[1]
		self.heapList[1] = self.heapList[self.currentSize]
		self.currentSize -=1
		self.heapList.pop()
		self.percolateDown(1)
		# dont care about the value which is there in the
		# top of the list
		return minVal

