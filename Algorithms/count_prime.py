#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
import math

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
        if (n>1):
        	all_primes = [1 for i in range(n)]
        	all_primes[0]=0
        	all_primes[1]=0

        	ranger = int(math.sqrt(len(all_primes)))+1
        	
        	for i in range(2, ranger):	
        		if all_primes[i]==1:
        			for j in range(2,n):
        				index = i*j
        				if (index)<n:	
        					all_primes[(index)]=0
        				
        					
        	return sum(all_primes)
        else:
        	return 0


sol = Solution()
print sol.countPrimes(3)