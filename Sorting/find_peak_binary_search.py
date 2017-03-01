#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

class Solution(object):

    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length =  len(nums)
        if(length>1):    
            low =0
            high = length-1
            while(low<high):
                mid = low + (high-low)/2
                if(nums[mid]==nums[mid+1]):
                    high = mid 
                else:
                    low = mid+1
            return nums[low]
        else:
            return 0



sol = Solution()
print sol.findPeakElement([2,2,3,4,5])