#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


def longest_common_subsequence(str1,str2):

	# always keep longer length in column
	len_1 = len(str1)
	len_2 = len(str2)
	if(len_2>len_1):
		temp=len_1
		len_1= len_2
		len_2=temp
		temp_str = str1
		str1 = str2
		str2 = temp_str


	str1 = " "+str1
	str2 = " "+str2

	# always str2 is the shortest and forms the rows and str1 is the longest
	# and forms the columns

	T = [[0 for i in range(len_1+1)] for j in range(len_2+1)]


	# there are 0, len of str1 columns
	#  and 0 to len of str2 rows
	#  strat from first row and first column
	for j in range(1,len(str1)):
		for i in range(1,len(str2)):
			if(str2[i]!=str1[j]):
				T[i][j] =  max(T[i-1][j],T[i][j-1])
			else:
				T[i][j] = 1+T[i-1][j-1]

	return T[-1][-1]


print longest_common_subsequence('acbcf','abcdaf')



