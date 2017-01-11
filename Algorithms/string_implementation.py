#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
import re
class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
    # We have to know if needle is a part of haystick
    # we know that haystick has to be a larger word
    

        if len(haystack)<len(needle):
            return -1
    # we only have to iterate through len(haystack) - len(needle) to find if
    # needle is there in haystack.
        for i in range(len(haystack)-len(needle)+1):
            if haystack[i:i+len(needle)]==needle:
                return i

        return -1


    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        MAX_INT = 2147483647
        MIN_INT = -2147483648
        str = str.strip()
        
        try:
            first_alphabet_in_string =  re.search('[A-Za-z\s]',str)
            if first_alphabet_in_string!=None:
                str = str[:first_alphabet_in_string.start()]
            str = int(str)
            if str>MAX_INT:
                return MAX_INT
            elif str<MIN_INT:
                return MIN_INT
            else:
                return str
        except ValueError:
            return 0

        

sol = Solution()
print sol.strStr('bacardi','car')
print sol.myAtoi('123  456')
