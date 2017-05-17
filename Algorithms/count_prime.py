s#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
import math
#  do check this
class Solution(object):
    def isPrime(self,n):
    	if (n==1):
    		return False
    	else:
	    	divisor_range = int(math.sqrt(n))
	    	while(divisor_range>1):
	    		if n%divisor_range==0:
	    			return False
	    		divisor_range-=1

	    	return True
	

    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        nums = [1 for i in range(n)]
        nums[0]=0
        nums[1]=0

        consider_till = int(math.sqrt(n))+1
        for i in range(consider_till):
            if(nums[i]==1):
                nums[i*i:n:i]= [0]*len(nums[i*i:n:i])
        return sum(nums)   


sol = Solution()
print sol.countPrimes(10)