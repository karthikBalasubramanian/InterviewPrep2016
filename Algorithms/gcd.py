

def gcd(num1,num2):
	#  be it any number it will work
	# check num1%num2!=0
	#  swap
	#  while swapping ensure to set num 2 temp%num2
	while(num1%num2!=0):
		temp = num1
		num1 = num2
		num2 = temp%num2

	return num2


print gcd(32,15)