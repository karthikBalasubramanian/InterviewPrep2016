#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

class Deque:

	def __init__(self):
		self.items = []

	def add_front(self,item):
		self.items.append(item)

	def add_rear(self,item):
		self.items.insert(0,item)

	def remove_front(self):
		return self.items.pop()

	def remove_rear(self):
		return self.items.pop(0)

	def size(self):
		return len(self.items)

	def isEmpty(self):
		return self.items == []



d=Deque()
print(d.isEmpty())
d.add_rear(4)
d.add_rear('dog')
d.add_front('cat')
d.add_front(True)
print(d.size())
print(d.isEmpty())
d.add_rear(8.4)
print(d.remove_rear())
print(d.remove_front())
