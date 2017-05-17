#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

import collections
class Solution(object):
    def candidates_add(self,num,max):
    	if num==max:
    		return num
    	else:
    		return num+1

    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        count = 0
        
        while(True):
            nums = [self.candidates_add(i,max(nums)) for i in nums]
            print collections.Counter(nums).values()
            count+=1
            if (collections.Counter(nums).values()[0] == len(nums)):
            	break
            
        
        return count+1


sol = Solution();
print sol.minMoves([1,2])