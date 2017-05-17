#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        div_by_two=0
        div_by_three=0
        div_by_five=0
        final_list = [1]
        while(n>1):
            u1= 2*final_list[div_by_two]
            u2=3*final_list[div_by_three]
            u3=5*final_list[div_by_five]
            min_num = min((u1,u2,u3))
            if(min_num == u1):
                div_by_two+=1
            
            if (min_num == u2):
                div_by_three+=1
            
            if(min_num==u3):
                div_by_five+=1
            
            print min_num
            
            final_list.append(min_num)
            print u1,u2,u3,min_num
            print final_list
            n-=1
        return final_list[-1]




sol = Solution()
print sol.nthUglyNumber(7)