#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

def make_incrementor (n): return lambda x: x + n

# def multiply(i):
# 	return lambda x:i*x
# final_list = []
# for i in range(4):
# 	final_list.append(multiply(i))

# print [i(2) for i in final_list]

def multiply():
	# return a list
	# each element is multiplied a lambda expression
	# but what happens is that as i is multiplied to lambda expression,
	# the expression changes.
	# therefore the expression remains to be the i which is the last element in the list
	# in this case range(4)-1 
	return [lambda x:i*x for i in range(4)]

def multiply_one():
	# return a list
	# each element is multiplied a lambda expression
	# but what happens is that as i is multiplied to lambda expression,
	# the expression changes.
	# therefore the expression remains to be the i which is the last element in the list
	# in this case range(4)-1 
	return [lambda x,i=i:i*x for i in range(4)]



print [i(2) for i in multiply()]
print [i(2) for i in multiply_one()]


# m = multiply()
# print type(m)

f = make_incrementor(2)
print make_incrementor(22)(33)

print f(32)