#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


def is_pow_two(n):

    #  if number is a power of 2,
    #  then number&number-1 == 0 else it will have more number of 1s as bit digits.
    #  important check for number less than 0
    #  bit and for negative operators result to 0
    return bool(n and not(n&(n-1)))



def counting_ones_in_number(n):
    # count the number of digits between n and its nearest power of 2. Basically.2

    count = 0
    while(n):
        n= n&(n-1)
        count+=1

    return count

def check_ith_element_one_or_not(n,i):
    if(n and (1<<i)):
        return True
    else:
        return False

def possible_subsets(nums):
    final_list = []
    for i in range(1<<len(nums)):
        int_list = []
        for j in range(len(nums)):
            if(i&(1<<j)):
                int_list.append(nums[j])
        final_list.append(int_list)
    return final_list

def next_largest_power_of_two_after_n(n):
    # assuming 16 bit integer
    n=n|(n>>1)
    n=n|(n>>2)
    n=n|(n>>4)
    n=n|(n>>8)

    return (n+1>>1)

def power_of_a_number(n,base):
    while(n%base==0):
        n//=base

    return n==1


def sortColors(nums):

    length_of_array = len(nums)
    for i in range(length_of_array-1):
        amin = i
        for j in range(i+1,length_of_array):
            if nums[j]<nums[amin]:
                amin = j
        temp =  nums[i]
        nums[i] = nums[amin]
        nums[amin] = temp


    return nums

print is_pow_two(64)
print counting_ones_in_number(3)
print check_ith_element_one_or_not(36,32)
print possible_subsets([1,2,3])
print next_largest_power_of_two_after_n(23)
print power_of_a_number(10,3)
print sortColors([0,1,1,2,0,1,2,2])