#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

import random

def swap(alist,i,j):
	temp =alist[i]
	alist[i]=alist[j]
	alist[j]=temp

def selection_sort(candidates):

	# length_of_candidates = len(candidates)
	# for i in range(length_of_candidates-1):
	# 	amin = i
	# 	for j in range(i+1,length_of_candidates):
	# 		if candidates[j]<candidates[amin]:
	# 			amin = j
	# 	temp =  candidates[i]
	# 	candidates[i] = candidates[amin]
	# 	candidates[amin] = temp
	length_of_candidates = len(candidates)
	
	for i in range(length_of_candidates-1,0,-1):
		position_of_max = 0
		for j in range(1,i+1):
			if candidates[j]>candidates[position_of_max]:
				position_of_max = j

		temp = candidates[position_of_max]
		candidates[position_of_max] = candidates[i]
		candidates[i] = temp

	return candidates



a = [random.randint(1,10) for i in xrange(10)]
print selection_sort(a)