#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

import collections
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        counter = 0

        for i in nums:
        	if(counter<2 or i>nums[counter-2]):
        		nums[counter]=i
        		counter+=1

        return nums[:counter]


    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        final_list = []
        for i in nums:
        	if(nums[abs(i)-1]<0):
        		final_list.append(abs(i))
        	else:
        		nums[abs[i]-1] *=-1

        return final_list
        
        
        




sol = Solution()
print sol.removeDuplicates([1,1,1,1,2,2,3])