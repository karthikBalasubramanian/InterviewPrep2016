#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
import math

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        final_list = []
        for i in range(len(nums)):
            sum=0
            for j in range(i,len(nums)):
                sum+=nums[j]
                final_list.append((sum,nums[i:j+1]))
        
        max =  final_list[0][0]
        max_candidates = final_list[0][1]
        for val1,val2 in final_list:
            if (val1>max):
                max = val1
                max_candidates = val2
        return max,max_candidates

    def maxSubArrayMerge(self,nums):
        if len(nums)==1:
            return nums[0]
        else:
            mid = len(nums)//2
            left_candidates = nums[:mid]
            right_candidates = nums[mid:]
            left_mss = self.maxSubArrayMerge(left_candidates)
            right_mss = self.maxSubArrayMerge(right_candidates)

            left_max = left_candidates[-1] 
            right_max = right_candidates[0]
            sum=0
            for i in range(len(right_candidates)):
                sum+=right_candidates[i]
                right_max = max(sum,right_max)
            sum = 0
            for i in range(len(left_candidates)-1,-1,-1):
                sum+=left_candidates[i]
                left_max = max(sum, left_max)

            ans = max(left_mss,right_mss)
            print left_max,right_max,left_mss,right_mss,ans,left_max+right_max
            return max(ans,(left_max+right_max))

    def maxSubArrayKadane(self,nums):
        # final_list = []
        # sum=0
        # ans = -float('inf')
        # for i in nums:
        #   if(sum+i>0):
        #       final_list.append(i)
        #       sum+=i
                
        #   else:
        #       sum=0
        #       final_list = []
        #   ans = max(ans,sum)
        # if ans==0:
        #   ans =  max(nums)
        # return final_list,ans
        if len(nums)>1:
            sum=0
            ans = -float('inf')
            for i in nums:
                if(sum+i>0):
                    sum+=i
                else:
                    sum=0
                ans = max(ans,sum)
            if (ans==0):
                ans = max(nums)
            return ans
        
        else:
            return nums[0]



sol = Solution()
print sol.maxSubArray([-2,0,-1])
print sol.maxSubArrayMerge([8,-19,5,-4,20])
print sol.maxSubArrayKadane([-2,-1])