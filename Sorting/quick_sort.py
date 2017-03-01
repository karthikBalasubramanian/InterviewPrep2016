#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


def quicksort(array):
	quick_sort_helper(array,0,len(array)-1)

def quick_sort_helper(array,start,end):
	if(start<end):

		pivot =  find_pivot(array,start,end)
		quick_sort_helper(array,start,pivot-1)
		quick_sort_helper(array,pivot+1,end)

def find_pivot(array,start,end):
	pivot_value =  array[start]
	left_mark = start+1
	right_mark = end
	done = False
	
	while(not done):
		
		while (left_mark<=right_mark and array[left_mark]<=pivot_value):
			left_mark+=1
		
		while (right_mark>=left_mark and array[right_mark]>=pivot_value):
			right_mark-=1
		
		if(right_mark<left_mark):
			done = True
		
		else:

			temp = array[left_mark]
			array[left_mark] = array[right_mark]
			array[right_mark] = temp

	temp = array[start]
	array[start] = array[right_mark]
	array[right_mark]= temp

	return right_mark




# def quickSort(alist):
#    quickSortHelper(alist,0,len(alist)-1)

# def quickSortHelper(alist,first,last):
#    if first<last:

#        splitpoint = partition(alist,first,last)

#        quickSortHelper(alist,first,splitpoint-1)
#        quickSortHelper(alist,splitpoint+1,last)


# def partition(alist,first,last):
#    pivotvalue = alist[first]

#    leftmark = first+1
#    rightmark = last

#    done = False
#    while not done:

#        while leftmark <= rightmark and alist[leftmark] <= pivotvalue:
#            leftmark = leftmark + 1

#        while alist[rightmark] >= pivotvalue and rightmark >= leftmark:
#            rightmark = rightmark -1

#        if rightmark < leftmark:
#            done = True
#        else:
#            temp = alist[leftmark]
#            alist[leftmark] = alist[rightmark]
#            alist[rightmark] = temp

#    temp = alist[first]
#    alist[first] = alist[rightmark]
#    alist[rightmark] = temp


#    return rightmark

a = [54,26,93,17,77,31,44,55,20]
quicksort(a)
print a