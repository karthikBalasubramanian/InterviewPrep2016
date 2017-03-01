#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        
        if not nums:
            return False
        length = len(nums)

        if(k>= length):
            k = length-1
            
        dict = {}
        for index,value in enumerate(nums):
            
            if value in dict:
                neighbor_distance = map(lambda x: abs(x-index),dict[value])
                neighbor_distance = [i<=k for i in neighbor_distance]
                neighbor_distance = sum(neighbor_distance)

                if(neighbor_distance>0):
                    return True
                else:
                    dict[value].append(index)
            else:
                dict[value] = [index]
        # print dict
        return False


sol = Solution()
print sol.containsNearbyDuplicate([0,1,2,3,2,5],3)