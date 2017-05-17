#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
 
import random

def swap(alist,i,j):
	temp =alist[i]
	alist[i]=alist[j]
	alist[j]=temp

def bubble_sort(candidates):
	length_of_candidates =  len(candidates)-1
	#  bubble sort swaps each position if the prev number is smaller than the current number
	for i in range(length_of_candidates,0,-1):
		#  start from the end of the list till 0
		for j in range(i):
			#  run from 0 to i
			if(candidates[j]>candidates[j+1]):
				swap(candidates,j,j+1)
				print candidates

	return candidates

	# bubble sort ensures that in one pass, the  largest element is sorted properly.


 	# for i in range(length_of_candidates-1):
 	# 	# why n-i-2 We wont again go to the sorted part
 	# 	#  -2 because the last element has to be accessed. 
 	# 	for j in range(0,length_of_candidates-i-2):

 	# 		if(candidates[j]>candidates[j+1]):
 	# 			temp = candidates[j]
 	# 			candidates[j]= candidates[j+1]
 	# 			candidates[j+1]= temp

 	# return candidates

 	# for i in range(length_of_candidates):
 	# 	for j in random



a = [random.randint(1,10) for i in xrange(10)]
print a
print bubble_sort(a)
