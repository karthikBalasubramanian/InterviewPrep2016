#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        reverse_of_string = s[::-1]
        new_string = s+reverse_of_string
        print new_string
        print len(s)
        low=0
        high = len(new_string)-1
        while(low<high):
            if new_string[low]!=new_string[high]:
                break
            else:
                low+=1
                high-=1
        print low
        reverse_of_string =  reverse_of_string[low-1:]
        print reverse_of_string
        return (reverse_of_string+s)


sol= Solution()
print sol.shortestPalindrome("abcd")