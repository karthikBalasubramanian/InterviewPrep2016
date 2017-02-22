#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian



class Queue:
	def __init__(self):
		self.items  = []

	def enqueue(self,item):
		self.items.append(item)

	def dequeue(self):
		return self.items.pop(0)

	def isEmpty(self):
		return self.items==[]

	def size(self):
		return len(self.items)



def hot_potato(namelist,nums):
	sim_queue= Queue()
	for name in namelist:
		sim_queue.enqueue(name)

	while sim_queue.size()>1:
		# after nums passes
		for i in range(nums):
			sim_queue.enqueue(sim_queue.dequeue())
		# remove the player in the front
		sim_queue.dequeue()
	# the winner is 
	return sim_queue.dequeue()


print(hot_potato(["Bill","David","Susan","Jane","Kent","Brad"],7))

# q = Queue()

# print q.isEmpty()
# q.enqueue(4)
# q.enqueue('dog')
# q.enqueue(True)
# print q.size()
# print q.isEmpty()
# q.enqueue(8.4)
# print q.dequeue()
# print q.dequeue()
# print q.size()