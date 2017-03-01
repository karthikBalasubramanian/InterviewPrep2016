#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

import random
def insertion_sort(array):

	len_of_array = len(array)
	for i in range(1,len_of_array):
		current_value =  array[i]
		position =  i

		while(position>0 and array[position-1]>current_value):
			array[position]=array[position-1]
			position=position-1

		array[position] = current_value

	return array


a = [random.randint(1,10) for i in xrange(10)]
print insertion_sort(a)