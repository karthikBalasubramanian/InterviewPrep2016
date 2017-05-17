#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

import random

class Solution(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.original =  nums[:]
        self.shuffled =  nums[:]
    def reset(self):
        """
        Resets the candidates to its original configuration and return it.
        :rtype: List[int]
        """
        self.temp = self.original[:]
        self.shuffled = self.original[:]
    
        return self.original
        

    def shuffle(self):
        """
        Returns a random shuffling of the candidates.
        :rtype: List[int]
        """
        
        for i in range(len(self.shuffled)):

            temp_el = random.choice(self.temp)
            self.shuffled[i] =  temp_el
            self.temp.remove(temp_el)
        
        self.temp = self.original[:]
        return self.shuffled
        # self.fisher_yates()
    

    def fisher_yates_shuffle(self,items):
        for i in range(len(items)):
            randomIndex = random.randint(i, len(items)-1)
            print i,randomIndex, random.randint(2,2)
            temp = items[randomIndex]
            items[randomIndex] = items[i]
            items[i] = temp
        return items
    


    def swap(self,num1,num2):
        temp_index = num1
        self.temp[num1] =  self.temp[num2]
        self.temp[num2] = self.temp[temp_index]


# Your Solution object will be instantiated and called as such:
obj = Solution([1,2,3])
param_1 = obj.reset()
print param_1
param_2 = obj.shuffle()
print obj.fisher_yates_shuffle(list('ABC'))