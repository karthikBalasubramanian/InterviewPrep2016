#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


class Solution(object):
    def canPartition(self, nums):
        #  check this
        """
        :type nums: List[int]
        :rtype: bool
        """
        list_sum = sum(nums)
        if list_sum%2 !=0:
            return False
        
        nums.insert(0,-1111)
        # otherwise, it becomes a subset sum problem.
        #  real easy
        list_sum = list_sum/2
        T = [[False for i in range(list_sum+1)] for i in range(len(nums))]
        print nums
        print T
        for i in range(len(T)):
        	T[i][0] = True
        # # columns
        for j in range(1,list_sum+1):
        	#  num rows
        	for i in range(1,len(nums)):

        		if nums[i]> j:
        			T[i][j] = T[i-1][j]
        		else:
        			if T[i-1][j]:
        				T[i][j] = T[i-1][j]
        			else:
        				T[i][j] = T[i-1][j-nums[i]]

        return T[-1][-1]


sol  = Solution()
print sol.canPartition([1, 5, 11, 5])