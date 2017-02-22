#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


class Stack:
	def __init__(self):
		self.items = []
	
	def isEmpty(self):
		return self.items==[]

	def push(self,item):
		self.items.append(item)

	def peek(self):
		return self.items[len(self.items)-1]

	def pop(self):
		return self.items.pop()

	def size(self):
		return len(self.items)


def match(open,close):
	if open=='(' and close==')':
		return True
	elif open=='[' and close==']':
		return True
	elif open=='{' and close=='}':
		return True
	else:
		return False


def paranthesis_checker(array):
	s=Stack()
	balanced = True
	index = 0
	while(index<len(array)) and balanced:
		if(array[index]in'([{'):
			s.push(array[index])
		elif (array[index]in')}]'):
			if s.isEmpty():
				balanced=False
			else:
				last_val =  s.pop()
				if not match(last_val,array[index]):
					balanced=False
		else:
			continue

		index +=1

	if balanced and s.isEmpty():
		return True
	else:
		return False


def decimal_to_any_base(number,base):
	digits = "0123456789ABCDEF"
	binary_stack = Stack()
	
	while(number>0):
		remainder = number%base
		binary_stack.push(remainder)
		number = number//base
	
	binary_val = ""
	while not binary_stack.isEmpty():
		binary_val = binary_val+digits[binary_stack.pop()]

	return binary_val


def infix_to_postfix(string):
	expression = list(string)
	output_list = list()
	op_stack = Stack()
	precedence_dict = {}
	precedence_dict['^']=4
	precedence_dict['(']=1
	precedence_dict['*']=3
	precedence_dict['/']=3
	precedence_dict['+']=2
	precedence_dict['-']=2
	alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
	integers = '0123456789'
	for i in expression:
		if i in alphabet or i in integers:
			output_list.append(i)
		elif i == '(':
			op_stack.push(i)
		elif i == ')':
			while op_stack.peek()!='(':
				output_list.append(op_stack.pop())
		
		elif i in precedence_dict:
			
			while not op_stack.isEmpty() and precedence_dict[op_stack.peek()]>=precedence_dict[i]:
				output_list.append(op_stack.pop())
			op_stack.push(i)
		else:
			continue

	while not op_stack.isEmpty():
		if op_stack.peek()!='(':
			output_list.append(op_stack.pop())
		else:
			op_stack.pop()

	return "".join(output_list)

def compute(operator, first_op,second_op):
	if operator == '+':
		return first_op+second_op
	elif operator =='-':
		return first_op-second_op
	elif operator == '*':
		return first_op*second_op
	elif operator=='/':
		return first_op/second_op
	elif operator == '**':
		return first_op**second_op



def postfix_evaluation(string):
	expression = string.split(" ")
	output_list = list()
	op_stack =  Stack()
	integers = '0123456789'
	for i in expression:
		if i not in '+-/*':
			op_stack.push(int(i))
			
		else:
			# print compute(i,op_stack.pop(),op_stack.pop())
			second_value  = op_stack.pop()
			first_value = op_stack.pop()
			value  = compute(i,first_value,second_value)
			
			op_stack.push(value)

	return op_stack.peek()

print paranthesis_checker('[{()]')
print decimal_to_any_base(26,26)
print infix_to_postfix("5 * 3 ^ (4 - 2)")
print(postfix_evaluation("- + * 2 3 * 5 4 9"))

# print(s.isEmpty())
# s.push(4)
# s.push('dog')
# print(s.peek())
# s.push(True)
# print(s.size())
# print(s.isEmpty())
# s.push(8.4)
# print(s.pop())
# print(s.pop())
# print(s.size())