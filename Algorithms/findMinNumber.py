#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
 
# O(n^2) solution
# Stupid solution
def findMinQuad(array):
	minVal =  array[0]
	for i in array:
		for j in range(len(array)):
			if array[j]<minVal:
				minVal = array[j]

	return minVal

# O(n) solition

def findMinLinear(array):
	minVal =  array[0]
	for i in range(len(array)):
		if array[i]<minVal:
			minVal = array[i]

	return minVal



print findMinQuad([3,5,6,1,2])
print findMinLinear([3,5,6,1,2])
