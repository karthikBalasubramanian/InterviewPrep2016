#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

# gentle tutorial to classes
class Fraction:
	# formal parameter - self (a pointer to object itself)
	# variables of a class are called state.called
	# methods of a class are called actions
	def __init__(self,num,den):
		# fraction object to have an internal data object called num
		self.num = num
		self.den = den


	def __str__(self):
		return str(self.num)+"/"+str(self.den)

	def __add__(self,other_fraction):
		new_num =  (self.num * other_fraction.den) + (self.den * other_fraction.num)
		new_den =  self.den*other_fraction.den
		common  = self.gcd(new_num,new_den)
		
		return Fraction(new_num//common,new_den//common)


	def __sub__(self,other_fraction):
		new_num =  (self.num * other_fraction.den) - (self.den * other_fraction.num)
		new_den =  self.den*other_fraction.den
		common  = self.gcd(new_num,new_den)
		
		return Fraction(new_num//common,new_den//common)

	def __mul__(self,other_fraction):
		new_num =  self.num * other_fraction.num
		new_den =  self.den*other_fraction.den
		common  = self.gcd(new_num,new_den)
		
		return Fraction(new_num//common,new_den//common)

	def __truediv__(self,other_fraction):
		new_num =  self.num * other_fraction.den
		new_den =  self.den*other_fraction.num
		common  = self.gcd(new_num,new_den)

		return Fraction(new_num//common,new_den//common)
	# works only when denominator is positive
	def gcd(self, num1,num2):
		while(num1%num2!=0):
			temp = num1
			num1 = num2
			num2 = temp%num2

		return num2
	# deep equivalence
	# overriding shallow equivalence (reference check)
	def __eq__(self,other):
		num1 = self.num*other.den
		num2 = self.den *other.num

		return num1==num2

	def __lt__(self,other):
		num1 = self.num*other.den
		num2 = self.den *other.num

		return num1<num2

	def __gt__(self,other):
		num1 = self.num*other.den
		num2 = self.den *other.num

		return num1>num2



myFraction = Fraction(1,9)
otherFraction = Fraction(2,10)
print myFraction-otherFraction
print myFraction * otherFraction
print myFraction>otherFraction