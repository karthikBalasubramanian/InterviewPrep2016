#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        return reduce(lambda x,y:(26*x)+y, [ord(i)-64 for i in list(s)])

sol = Solution()
print sol.titleToNumber('AAA')