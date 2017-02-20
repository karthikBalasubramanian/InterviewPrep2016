#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
import random

def newtons_method(n):
	guess =  float(n/2)
	for i in range(30):
		new_guess = float(n/guess)
		guess =  0.5*(guess+new_guess)

	return guess

print newtons_method(13)

# infinite monkey problem
def generate_one(strlen):
	s = 'abcdefghijklmnopqrstuvwxyz '
	randomString  = ""

	for i in range(strlen):
		randomString = randomString+ s[random.randrange(len(s))]
	
	return randomString

def score(goal,randomString):
	my_score = 0
	for i in range(len(goal)):
		if goal[i]==randomString[i]:
			my_score+=1

	return my_score/float(len(goal))



def main():
	goalString = "methinks it is like a weasel"
	randomString =  generate_one(len(goalString))
	best = 0
	new_score = score(goalString,randomString)
	while new_score<1:
		if new_score > best:
			best = new_score
			print best, randomString
		randomString = generate_one(len(goalString))
		new_score = score(goalString,randomString)

main()
