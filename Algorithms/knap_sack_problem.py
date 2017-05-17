#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


# you are given two arrays
# weight and values
# you are given a target weight which you cant exceed
# how would you pick weights such that they dont exceed target weight at the same time they
# get you the maximum values
# weights are non zero positive values
# so are values

def knapsack(target,weights,values):
	
	# create a dummy matrix of weight columns and target rows
	# all initialized to empty
	T = [[0 for i in range(target+1)] for j in range(len(weights))]
	# columns
	T[0][values[0]:] =  [values[0]]*len(T[0][values[0]:]) 

	print T
	for j in range(target+1):
		# row
		for i in range(1,len(weights)):
			# if the target is less than the weights in that position
			if j<weights[i]:
				# final value is the value from previous row's jth column

				T[i][j] = T[i-1][j]
			else:
				# else you can either choose or not choose the current weight's values based on a condiiton
				# max of the value for the given weight + left out weight's value  and weight's value considering
				#  this new weight does not even exist
				T[i][j] =  max(values[i]+T[i-1][j-weights[i]],T[i-1][j])
			
	print T			
	print T[len(weights)-1][target]



knapsack(7,[1,3,4,5],[1,4,5,7])