#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        final_list =  [i for i in range(1,n+1)]
        my_list = []
        for i in range(1<<n):
        	sub_list =[]
        	for j in range(n):
        		if i&(1<<j):
        			sub_list.append(final_list[j])
        	
        	if(len(sub_list)==k):
        		my_list.append(sub_list)
        	

        print my_list
        			



sol = Solution()
sol.combine(20,16)