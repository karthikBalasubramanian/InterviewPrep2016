#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian



class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        # pure math
        result = 0
        quotient =0
        remainder =0
        abs_number = abs(x)
        while(abs_number>0):
        	quotient = abs_number/10
        	remainder = abs_number%10
        	result = remainder + result *10
        	abs_number = quotient

        if result > (2**31):
        	return 0
        elif x>0:
        	return result
        else:
        	return -1*result

    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        str = str.strip()
        pos =0
        for i in str:
            if not i.isalpha():
                pos+=1
            else:
                break
                
        str =  str[:pos]
        print str
        
        try:
            str = int(str)
            if str>(2**31-1):
                return 2147483647
            elif str < -(2**31):
                return -2147483648
            else:
                return str
        except ValueError:
            return 0


sol = Solution()
print sol.reverse(1000000003)
print sol.myAtoi("123 456")

