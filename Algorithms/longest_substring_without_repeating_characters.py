#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


class Solution(object):
    def __init__(self):
        self.dict = {}
        self.memo = {}

    def findLongestWord(self, s, d):
        """
        :type s: str
        :type d: List[str]
        :rtype: str
        """
        pass
    def fibonnaci_iterative(self,n):

        final_list = [i for i in range(n+1)]
        for i in range(2,n+1):

            final_list[i] = final_list[i-1]+final_list[i-2]

        print final_list

    def recursive_fib(self,n):
        if n<=1:
            return 1
        else:
            return self.recursive_fib(n-1)+self.recursive_fib(n-2)
    def recursion_with_memoization(self,n):
        
        if n in self.dict:
            print "{0} value is already there in dict".format(n)
            return self.dict[n]
        if n<=1:
            return 1
        else:
            f = self.recursion_with_memoization(n-1)+  self.recursion_with_memoization(n-2)
            self.dict[n]=f

            return f
    def bottom_up_dp(self,n):
        for i in range(n+1):
            if(i<2):
                f = 1
            else:
                f = self.memo[i-1]+self.memo[i-2]
            self.memo[i]=f

        return self.memo[n]

sol = Solution()
# print sol.cumsum([1,2,4])
print sol.fibonnaci_iterative(5)
print sol.recursion_with_memoization(5)
print sol.bottom_up_dp(5)