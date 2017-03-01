#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        #  we will use counting sort when we know the array is static and it wont grow anymore
        # lets do with counting sort

        if(len(nums)>1):
            count_dict={}
            output = nums[:]
            count_dict = {i:0 for i in range(max(nums)+1)}
            # create the dictionary from min to max. min being 0
            for i in nums:
                count_dict[i]+=1

            print count_dict
                
            # cumulative sum in dictionary
            for i in count_dict:
                if i-1 in count_dict:
                    count_dict[i]+=count_dict[i-1]
                

            print count_dict
            for i in output:
                count_dict[i]-=1
                nums[count_dict[i]] = i
                

            print nums






sol =  Solution()
sol.sortColors([1,0])