#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        
        # for i in range(len(matrix)):
        #     for j in range(len(matrix[0])):
        #         if target == matrix[i][j]:
        #             return True
        
        if not matrix:
            return False
        else:
            row_length = len(matrix)-1
            col_length = len(matrix[0])-1
            i=0 
            j=col_length
            #  lets say its a 3X3 matrix
            #  start from 1st row and third colum
            #  if the number is what they expect
            #  print the number
            #  else if number is less than the index number
            #  got to the left of the row
            #  else go to the next row
            #  start fr
            while(i<=row_length and j>=0):
                if(target == matrix[i][j]):
                    # 
                	print matrix[i][j]
                	return True
                elif(target > matrix[i][j]):
                    print matrix[i][j]
                    i+=1
                elif(target < matrix[i][j]):
                    print matrix[i][j]
                    j-=1
            
        return False


sol = Solution()
print sol.searchMatrix([[-10,-8,-6,-4,-3],[0,2,3,4,5],[8,9,10,10,12]],0)