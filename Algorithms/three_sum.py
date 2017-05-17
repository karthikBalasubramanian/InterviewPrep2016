#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian





class Solution(object):
    # val1+val2=target
    # val1-target = -val2
    

    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        final_list = []
        i = 0
        j= 1
        k = len(nums)-1
        while(i<k):
            print i,j,k
            while(j<k):
                three_sum =  nums[i]+nums[j]+nums[k]
                if(three_sum==0):
                    final_list.append([nums[i],nums[j],nums[k]])
                    j+=1
                    k-=1
                elif(three_sum>0):
                    k-=1
                else:
                    j+=1
            i+=1
            j=i+1
            k = len(nums)-1

        return final_list 



    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        
        vowels = 'aeiouAEIOU'
        s = list(s)
        low = 0
        high = len(s)-1
        while(low<high):
            print s[low],s[high]
            if s[low] in vowels and s[high] in vowels:
                temp =  s[low]
                s[low]=s[high]
                s[high]=temp
                low+=1
                high-=1
                
            elif s[low] in vowels:
                
                high-=1
            elif s[high]in vowels:

                low+=1
            else:
                low+=1
                high-=1
                
        return "".join(s)

    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        last_list = []
        marker = 0
        for i in range(1,len(nums)):
            if nums[i]!=nums[i-1]+1:
                if marker ==  i-1:
                    #  checking for 2 element array
                    last_list.append("{0}".format(nums[i-1]))
                else:
                    last_list.append("{0}->{1}".format(nums[marker],nums[i-1]))
                marker=i
        
        if marker!=len(nums)-1:
            last_list.append("{0}->{1}".format(nums[marker],nums[-1]))
       
        else:
            last_list.append("{0}".format(nums[-1]))
        
                

        return last_list


    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        if len(num)<=k:
            return "0"
        stack = []
        i=0
        
        while(i<len(num)):
            while(k>0 and stack and stack[-1]>num[i]):
                stack.pop()
                k-=1
            
            stack.append(num[i])
            i+=1
            print stack

        while(k>0):
            stack.pop()
            k-=1
        
       
        return str(int("".join(stack)))


    def oddEvenSum(self,nums):
        length = len(nums)
        if length==3:
            nums[0] = nums[0]+nums[2]
            return nums[:2]

        if length<=2:
            return nums
        else:
            
            nums[length-3] =  nums[length-1]+nums[length-3]
            nums[length-4] = nums[length-2]+nums[length-4]
            print nums
            return self.oddEvenSum(nums[:length-2])



sol = Solution()
print sol.reverseVowels("Euston saw I was not Sue.")
print sol.summaryRanges([0,1,2,4,5,7])
sol.removeKdigits("1432219",3)
print sol.oddEvenSum([1,2,3,4,5,6,8,9,10])

print sol.threeSum([3,0,-2,-1,1,2])