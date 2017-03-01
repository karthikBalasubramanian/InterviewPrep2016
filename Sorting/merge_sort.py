#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
 

def merge_sort(array):
	if(len(array)>1):

		divider =  len(array)//2
		print "splitting list {0}".format(array)
		# storing memory costs
		left_half =  array[:divider]
		right_half =  array[divider:]
		merge_sort(left_half)
		merge_sort(right_half)

		i=0
		j=0
		k=0

		while(i<len(left_half) and j<len(right_half)):
			if(left_half[i]<right_half[j]):
				array[k] = left_half[i]
				i+=1
			else:
				array[k] =  right_half[j]
				j+=1
			
			k+=1

		while (i<len(left_half)):
			array[k] = left_half[i]
			i+=1
			k+=1
		while(j<len(right_half)):
			array[k] = right_half[j]
			j+=1
			k+=1

		print "merging {0}".format(array)

	return array




print merge_sort([54,26,93,17,77,31,44,55,20])