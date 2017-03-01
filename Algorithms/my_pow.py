#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        
        if(n==0):
            return 1
        if(n<0):
            n= -n
            x = 1/x
        
        if n%2==0:
            y= self.myPow(x,n//2)
            return y*y
        else:
            
            return x*self.myPow(x,n-1)

sol = Solution()
print sol.myPow(3,6)