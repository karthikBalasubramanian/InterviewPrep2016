#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


class Solution(object):
    def maxSubArrayLen(self, nums, k):
    	ans, acc = 0, 0               # answer and the accumulative value of nums
    	mp = {0:-1}                 #key is acc value, and value is the index
    	for i in xrange(len(nums)):
    		#  accumulated value
    		acc += nums[i]
        	if acc not in mp:
        		#  if accumulated value not in map, add it to map
        		mp[acc] = i 
        		
        	if acc-k in mp:
        		#  if accumulated value - target is in map, then accumulated value and target has to be 0
        		#  which means accumulated value = target
        		#  so update ans with max of ans and diff(index of the current acc value and mp[acc-k])
        		ans = max(ans, i-mp[acc-k])
    	return ans

    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        start =-1
        end = -1
        min_val =  len(nums)-1
        
        for index,value in enumerate(nums):
            current_sum = 0
            for index_2 in range(index,len(nums)):
                current_sum +=nums[index_2]
                if current_sum==s:
                	start =  index
                	end = index_2
                	min_val = min(min_val,(end-start+1))
                	break

        print nums[start:end]



sol = Solution()
print sol.maxSubArrayLen([1, -1, 5, -2, 3],3)

