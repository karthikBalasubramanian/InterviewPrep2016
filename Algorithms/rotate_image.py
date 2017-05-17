
#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        #  first reverse up to down, then swap the symmetry

        # i=0
        # j= len(matrix)-1

        # while (i<j):
        # 	temp  =  matrix[i][:]
        # 	matrix[i][:] = matrix[j][:]
        # 	matrix[j][:] =  temp
        # 	i+=1
        # 	j-=1

        # for i in range(len(matrix)):
        # 	j=0
        # 	while(j<i):
        # 		temp = matrix[i][j]
        # 		matrix[i][j]= matrix[j][i]
        # 		matrix[j][i] = temp
        # 		j+=1

        # return matrix
        matrix.reverse()
        print matrix
        return zip(*matrix)




sol = Solution()
print sol.rotate([[1,2,3],[4,5,6],[7,8,9]])