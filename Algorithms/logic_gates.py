#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

# classes inheritance

class LogicGate:

	# each gate has a label for identification and a single output line. 
	# In addition, we need methods to allow a user of a gate to ask the gate for its label.

	def __init__(self,n):
		self.label = n
		self.output = None

	def get_label(self):
		return self.label