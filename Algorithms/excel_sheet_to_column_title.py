#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        # we have a number and we have to convert it into a letter
        stri = ''
        chrx = [chr(i) for i in range(ord('A'),ord('Z')+1)]

        while(n>0):
        	n=n-1
       		stri =chrx[n%26]+stri
        	n=n/26
        	

        return stri

sol = Solution()
print sol.convertToTitle(26)