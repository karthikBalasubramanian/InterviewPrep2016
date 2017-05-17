#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

def spiral_traversal(candidates):
	top_row = 0
	left_col = 0
	right_col =  len(candidates[0])-1
	bottom_row = len(candidates)-1

	direction = 0
	final_list = []
	while top_row<=bottom_row and left_col<=right_col:
		
		if(direction==0):
			for i in range(left_col,right_col+1):
				print "in direction 0 {0}".format(i)
				final_list.append(candidates[top_row][i])
			top_row+=1
			
		
		elif (direction==1):
			print right_col
			for i in range(top_row,bottom_row+1):
				print "in direction 1 {0}".format(i)
				final_list.append(candidates[i][right_col])
			right_col -=1
			
		
		elif(direction==2):
			for i in range(right_col,left_col-1,-1):
				print "in direction 2 {0}".format(i)
				final_list.append(candidates[bottom_row][i])
			bottom_row -=1
			
		
		elif(direction==3):
			for i in range(bottom_row,top_row-1,-1):
				print "in direction 3 {0}".format(i)
				final_list.append(candidates[i][left_col])
			left_col +=1
		
		direction = (direction+1)%4

	return final_list


print spiral_traversal([[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]])