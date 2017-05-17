#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        #  we will use counting sort when we know the candidates is static and it wont grow anymore
        # lets do with counting sort

        if(len(nums)>1):
            count_dict={}
            output = nums[:]
            #  create a dictionary from min to max
            #  key being the actual value in the list
            #  value being the count initialized to 0
            count_dict = {i:0 for i in range(max(nums)+1)}
            # create the dictionary from min to max. min being 0
            #  count occurences of the element in the dict
            for i in nums:
                count_dict[i]+=1

            print count_dict
            # for each i if i -1 in dict, i's count = i's count + i-1's count 
            # cumulative sum in dictionary
            for i in count_dict:
                if i-1 in count_dict:
                    count_dict[i]+=count_dict[i-1]
                

            
            for i in output:
                count_dict[i]-=1
                nums[count_dict[i]] = i
                

            print nums






sol =  Solution()
sol.sortColors([1,1,2,3,2,4,5])