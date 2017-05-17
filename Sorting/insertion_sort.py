#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

import random
def insertion_sort(candidates):

	len_of_candidates = len(candidates)
	for i in range(1,len_of_candidates):
		#  go from 1 to length of list
		#  ensure the values between position and 0 are always sorted
		#  Take the current_value
		#  take position of current value
		current_value =  candidates[i]
		position =  i

		while(position>0 and candidates[position-1]>current_value):
			#  keep swapping until the one of the two conditions are satisfied
			#  1. position should be greater than 0
			#  2. value @ position is less than value at position -1
			candidates[position]=candidates[position-1]
			position=position-1
			print candidates

		candidates[position] = current_value
		print candidates
	return candidates


a = [3,1,2,5]
# 3,3,2,5
#  1,3,2,5
#  1,3,3,5
#  1,2,3,5
# 1,2,3,5
print insertion_sort(a)