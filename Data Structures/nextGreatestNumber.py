#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

def nextGreatestNumber(nums,target):
	low = 0
	high = len(nums)-1

	while(low<high):

		mid =  low + (high-low)/2
		
		if(target>=nums[mid]):
			low =  mid+1
		
		else:
			high = mid

	
	if(nums[low]>target):
		return low
	else:
		return -1



print nextGreatestNumber([1,4,5,5,9],5)