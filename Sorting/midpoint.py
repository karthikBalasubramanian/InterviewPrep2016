#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


def findmidpoint(nums):

	low = 0
	high = len(nums)-1
	counter=nums[low]-nums[high]
	while(low<high):


		if counter<0:
			low+=1
			counter+=nums[low]
			
			

		elif counter>0:
			high-=1
			counter+=nums[high]
			
			

		elif counter==0:
			return nums[low]

		print low, high, counter

	return float('inf')


nums = [-7, 4, 5, 2, -4, 4, 2]

print findmidpoint(nums)
