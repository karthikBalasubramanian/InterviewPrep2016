#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
 
import random

def swap(alist,i,j):
	temp =alist[i]
	alist[i]=alist[j]
	alist[j]=temp

def bubble_sort(array):
	length_of_array =  len(array)-1

	for i in range(length_of_array,0,-1):
		for j in range(i):
			if(array[j]>array[j+1]):
				swap(array,j,j+1)

	return array
 	# for i in range(length_of_array-1):
 	# 	# why n-i-2 We wont again go to the sorted part
 	# 	#  -2 because the last element has to be accessed. 
 	# 	for j in range(0,length_of_array-i-2):

 	# 		if(array[j]>array[j+1]):
 	# 			temp = array[j]
 	# 			array[j]= array[j+1]
 	# 			array[j+1]= temp

 	# return array

 	# for i in range(length_of_array):
 	# 	for j in random



a = [random.randint(1,10) for i in xrange(10)]
print bubble_sort(a)
