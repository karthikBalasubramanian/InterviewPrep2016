#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
 

def merge_sort(candidates):
	if(len(candidates)>1):

		divider =  len(candidates)//2
		print "splitting list {0}".format(candidates)
		# storing memory costs
		left_half =  candidates[:divider]
		right_half =  candidates[divider:]
		
		merge_sort(left_half)
		merge_sort(right_half)
		#  runs over left list
		i=0  
		#  runs over right list
		j=0
		#  runs over candidate list
		k=0
		#  left and right half gets sorted after the child operation divide and conquer
		print "left half {0} right half {1}".format(left_half,right_half)
		while(i<len(left_half) and j<len(right_half)):
			if(left_half[i]<right_half[j]):
				candidates[k] = left_half[i]
				i+=1
			else:
				candidates[k] =  right_half[j]
				j+=1
			
			k+=1

		while (i<len(left_half)):
			candidates[k] = left_half[i]
			i+=1
			k+=1
		while(j<len(right_half)):
			candidates[k] = right_half[j]
			j+=1
			k+=1

		print "merging {0}".format(candidates)

	return candidates




print merge_sort([54,26,93,17,77,31,44,55,20])