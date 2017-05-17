#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


from StackInPython import Stack
from TreesInPython import BinaryTree
import operator


dict = {"+":operator.add,"-":operator.sub,"*":operator.mul,"/":operator.truediv}
def parse_tree(expression):
	exp_list = expression.split()
	print exp_list
	stacked = Stack()
	b_tree = BinaryTree("")
	stacked.push(b_tree)
	current_tree = b_tree

	for i in exp_list:
		if i=='(':
			# if you find a ( create a root node with  '' and push it in the stack
			current_tree.insertLeft('')
			parent = stacked.push(current_tree)
			# move to the left child
			current_tree = current_tree.getLeftChild()

		elif i not in ['+', '-', '*', '/', ')']:
			# if you find a number. immediately set it to the current root
			print current_tree.getRootVal()
			current_tree.setRootVal(int(i))
			#  move the current pointer to parent. Parent is obtained from stack
			parent = stacked.pop()
			current_tree = parent
		elif i in ['+','-','*','/']:
			#  set value to current root node.

			current_tree.setRootVal(i)
			current_tree.insertRight('')
			stacked.push(current_tree)
			current_tree= current_tree.getRightChild()
		elif i == ')':
			current_tree = stacked.pop()
		else:
			raise ValueError

    # finally return root
  	return b_tree


def printexp(tree):
  sVal = ""
  if tree:
      sVal = '(' + printexp(tree.getLeftChild())
      sVal = sVal + str(tree.getRootVal())
      sVal = sVal + printexp(tree.getRightChild())+')'
  return sVal


def evaluate(b_tree):
	left_child = b_tree.getLeftChild()
	right_child = b_tree.getRightChild()

	if left_child and right_child:
		ops = dict[b_tree.getRootVal()]
		return ops(left_child,right_child)
	else:
		return b_tree.getRootVal()


print "before function call"

pt = parse_tree("( ( 10 + 5 ) * 3 )")
print printexp(pt)