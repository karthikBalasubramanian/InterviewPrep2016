#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

import string

class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Given a sorted array, remove the duplicates in place such 
        # that each element appear only once and return the new length.
        # Do not allocate extra space for another array, 
        # you must do this in place with constant memory.


        # use two pointer technique
        # slow runner
        if not nums:
            return 0

        i=0
        # fast runner starts from second number
        for j in range(1,len(nums)):
            if nums[j] != nums[i]:
                i+=1
                nums[i]=nums[j]
        return i+1
    
    def swap(self,arr,pos_head,pos_tail):
        """
            swap two positions
        """
        temp = arr[pos_head]
        arr[pos_head]=arr[pos_tail]
        arr[pos_tail]=temp


    def reverse(self,arr):
        pos_head = 0
        pos_tail = len(arr)-1
        while(pos_head<pos_tail):
            self.swap(arr,pos_head,pos_tail)
            # two pointers. one increases and other decreases
            pos_head +=1
            pos_tail -=1
        return arr

    def twosum(self,arr,target):
        for i in range(len(arr)):
            for j in range(i+1,len(arr)):
                if arr[i]+arr[j]==target:
                    return [i,j]

    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # remove the
        s = s.lower().replace(" ","")
        s = "".join(i for i in s if i.isalnum())
        print s
        pos_head =0
        pos_tail = len(s)-1
        while(pos_head<pos_tail):
            if s[pos_head]!=s[pos_tail]:
                return False
            else:
                pos_head +=1
                pos_tail -=1

        return True

    # Given n non-negative integers a1, a2, ..., an, 
    # where each represents a point at coordinate (i, ai). 
    # n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
    # Find two lines, which together with x-axis forms a container, 
    # such that the container contains the most water.


    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        # Start with the best width
        # height is the minimum of the two heights

        pos_head =  0
        pos_tail =  len(height)-1
        max_area = 0
        while pos_head<pos_tail:
            max_area = max(max_area,(pos_tail- pos_head) * (min(height[pos_head],height[pos_tail])))
            # The smaller one of first and last line doesn't support a higher water level 
            # and can thus be safely removed from further consideration.
            if height[pos_head]<height[pos_tail]:
                pos_head +=1
            else:
                pos_tail -=1

        return max_area

    # Rotate Array
    # Rotate an array of n elements to the right by k steps.
    def reverse_all(self,arr,pos_head,pos_tail):
        while(pos_head<pos_tail):
            self.swap(arr,pos_head,pos_tail)
            pos_head +=1
            pos_tail -=1



    def rotate(self, nums, k):
        # k is the displacement 
        # linear time reversal of list has 3 simple step
        # 1. reverse a complete list
        # 2. reverse the list from k to len of arr
        # 3. reverse the list from 0 to k-1
        # boundary conditions: 1. check if size is greater than 1
        # check is k is not negative and greater than nums size

        if len(nums)<2 or k<0:
            return nums

        k %= len(nums)
        self.reverse_all(nums,0,len(nums)-1)
        self.reverse_all(nums,k,len(nums)-1)
        self.reverse_all(nums,0,k-1)

        return nums


    def productExceptSelf(self,nums):
        # algorithm is very simple. 
        # value of an index is multiplication of all its prefix numbers and all its suffix numbers
        # as we iterate, multiply prefix with previous numbers
        # we will run 2 loops
        # loop one prefix mulitplication in ascending order
        # loop two suffix multiplication in descending order

        prefix =1
        suffix = 1
        output = []
        for i in range(len(nums)):
            output.append(prefix)
            prefix *= nums[i]

        for i in range(len(nums)-1,-1,-1):
            output[i] *= suffix
            suffix *= nums[i]

        return output

            



my_sol = Solution()

print my_sol.removeDuplicates([1,1,1,1,2,2,2,2])
print my_sol.reverse(list("amma"))
print my_sol.twosum([2, 7, 11, 15],13)
print my_sol.isPalindrome("A man, a plan, a canal: Panama")
print my_sol.maxArea([3,5,6,2])
print my_sol.rotate([1,2,3],4)
print my_sol.productExceptSelf([0,1])