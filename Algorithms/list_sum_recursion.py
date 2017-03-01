#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


def list_sum(array):
	if len(array)==1:
		return array[0]
	else:
		return array[0] + list_sum(array[1:])


def num_with_any_base(num,base):
	if num<base:
		return str(num%base)
	else:
		return num_with_any_base(num//base,base)+str(num%base)


def reverse_num_with_any_base(num,base):
	if num<base:
		return str(num%base)
	else:
		return str(num%base)+reverse_num_with_any_base(num//base,base)

def check_palindrome_recursively(str):
	if len(str)==0 or len(str)==1:
		return True
	else:
		return ((str[0]==str[-1]) and (check_palindrome_recursively(str[1:-1])))



def check_palindrome(num):
	quotient = 0
	remainder= 0
	intial_num = num
	result = 0
	while(intial_num>0):
		quotient =  intial_num//10
		remainder = intial_num%10
		result =  (result*10)+remainder
		intial_num = quotient
	return result==num

def string_reverse(string):
	if (len(string))==1:
		return string
	else:
		return string[-1]+string_reverse(string[:-1])

print string_reverse("Wassamasaw")
print check_palindrome_recursively("hello")
print num_with_any_base(121,2)
print reverse_num_with_any_base(121,2)
print check_palindrome(123)
print list_sum([1,2,3,4])