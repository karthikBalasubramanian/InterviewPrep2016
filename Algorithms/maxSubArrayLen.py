class Solution(object):
    def maxSubArrayLen(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # if len(nums)>1:
        #     final_list = []
        #     for i in range(len(nums)):
        #         for j in range(i+1,len(nums)+1):
        #             if (sum(nums[i:j])==k):
        #                 final_list.append(j-i)
    
        #     if len(final_list)>0:
                
        #         return max(final_list)
        #     else:
        #         return 0
        # else:
        #     return 0
        final_dict = {}
        current_length = 0
        max_length = 0
        for i in range(len(nums)):
            sum+=nums[i]
            if sum==k:
                max_length +=1
            if((sum-k) in dict):
                current_length = i+1-final_dict[sum-k]
                max_length = max(max_length,current_length)
            else:
                


sol =Solution()
print sol.maxSubArrayLen([-2,-1,2,1],1)