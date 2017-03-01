#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        prefix =1
        suffix = 1
        output = []
        for i in range(len(nums)):
            output.append(prefix)
            prefix *= nums[i]
        print output

        for i in range(len(nums)-1,-1,-1):
            output[i] *= suffix
            suffix *= nums[i]

        return output


sol = Solution()
print sol.productExceptSelf([1,2,3,4])