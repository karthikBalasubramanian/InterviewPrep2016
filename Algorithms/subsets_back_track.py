#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        final_list = []
        nums.sort()
        self.subsets_backtrack(nums,0,final_list,[])
        return final_list

    def subsets_backtrack(self,nums,start,final,current):
        temp =  current[:]
        print "temp to be appended {0}".format(temp)
        final.append(temp)
        print "final_list now {0}".format(final)
        for i in range(start,len(nums)):
            current.append(nums[i])
            print "current after appending new value {0}".format(current)
            self.subsets_backtrack(nums,i+1,final,current)
            current.pop()
            print 
            print "array from start to final is {0}".format(nums[start:])
            print 
            print "current after removing last element {0} and i value is {1} and length {2}".format(current,i,len(nums))

    def permute(self,nums):
        final_list = []
        nums.sort()
        
        self.back_track_permute(final_list,[],nums)
        return final_list
        
        
    def back_track_permute(self,final_list,current,nums):
        if len(current)==len(nums):
            temp = current[:]
            final_list.append(temp)
        else:
            for i in range(len(nums)):
                if nums[i] not in current:
                    current.append(nums[i])
                    self.back_track_permute(final_list,current,nums)
                    current.pop()

    def combination_sum(self,nums,target):
        final_list = []
        nums.sort()
        
        self.back_track_com_sum(nums,0,final_list,[],target)
        return final_list
        
        
    def back_track_com_sum(self,nums,start,final_list,current,target):
        # if len(current)==len(nums):
        #     temp = current[:]
        #     final_list.append(temp)
        # else:
        #     for i in range(len(nums)):
        #         if nums[i] not in current:
        #             current.append(nums[i])
        #             self.back_track_permute(final_list,current,nums)
        #             current.pop()
        if target<0:
            return
        elif target==0:
            temp = current[:]
            final_list.append(temp)
        else:
            for i in range(start,len(nums)):
                if (i>start and nums[i]==nums[i-1]):
                    continue
                current.append(nums[i])
                self.back_track_com_sum(nums,i,final_list,current,target-nums[i])
                current.pop()



sol = Solution()
# print sol.subsets([1,1,2])
print sol.permute([1,2,3])