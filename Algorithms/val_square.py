#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

import collections
class Solution(object):
    def validWordSquare(self, words):
        """
        :type words: List[str]
        :rtype: bool
        """
        t = map(None, *words)
        print type(t)
        
        # 	return True
        # else:
        # 	return False
       	# if (a_mat == a_mat.T).all():
       	# 	return True
       	# else:
       	# 	return False


sol = Solution()
print sol.validWordSquare(["abcd","bnrt","crmy","dtye"])
print sol.validWordSquare(["abcd","bnrt","crm","dt"])