#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian



class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """

        num_rows = len(grid)
        num_columns = len(grid[0])

        min_path_matrix = [[0 for j in range(num_columns)] for i in range(num_rows)]
        # columns
        for j in range(num_columns):
        	for i in range(num_rows):
        		if j=0 and i=0:
        			min_path_matrix[i][j] =  grid[i][j]
        		elif j==0:
        			min_path_matrix[i][j] = min_path_matrix[i-1][j] + grid[i][j]
        		elif i==0:
        			min_path_matrix[i][j] = min_path_matrix[i][j-1]+grid[i][j]
        		else:
        			min_path_matrix[i][j] =  min(min_path_matrix[i-1][j],min_path_matrix[i][j-1])+grid[i][j]

        return min_path_matrix[-1][-1]