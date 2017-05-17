#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
 
# O(n^2) solution
# Stupid solution
def findMinQuad(candidates):
	minVal =  candidates[0]
	for i in candidates:
		for j in range(len(candidates)):
			if candidates[j]<minVal:
				minVal = candidates[j]

	return minVal

# O(n) solition

def findMinLinear(candidates):
	minVal =  candidates[0]
	for i in range(len(candidates)):
		if candidates[i]<minVal:
			minVal = candidates[i]

	return minVal



print findMinQuad([3,5,6,1,2])
print findMinLinear([3,5,6,1,2])
