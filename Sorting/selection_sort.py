#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

import random

def swap(alist,i,j):
	temp =alist[i]
	alist[i]=alist[j]
	alist[j]=temp

def selection_sort(array):

	# length_of_array = len(array)
	# for i in range(length_of_array-1):
	# 	amin = i
	# 	for j in range(i+1,length_of_array):
	# 		if array[j]<array[amin]:
	# 			amin = j
	# 	temp =  array[i]
	# 	array[i] = array[amin]
	# 	array[amin] = temp
	length_of_array = len(array)
	
	for i in range(length_of_array-1,0,-1):
		position_of_max = 0
		for j in range(1,i+1):
			if array[j]>array[position_of_max]:
				position_of_max = j

		temp = array[position_of_max]
		array[position_of_max] = array[i]
		array[i] = temp

	return array



a = [random.randint(1,10) for i in xrange(10)]
print selection_sort(a)