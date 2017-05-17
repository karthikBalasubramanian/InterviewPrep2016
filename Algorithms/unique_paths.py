#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        path_martix =  [[0 for i in range(n)] for j in range(m)]
        path_martix[0][:] = [1]*n
        for i in range(1,m):
        	path_martix[i][0] =1

        # columns
        for j in range(1,n):
        	# rows
        	for i in range(1,m):
        		path_martix[i][j] = path_martix[i-1][j]+path_martix[i][j-1]

        print path_martix

sol = Solution()
sol.uniquePaths(10,5)