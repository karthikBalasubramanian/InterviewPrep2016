#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

class Solution:
    def combinationSum2(self,candidates,target):
        


        final_list = []
        candidates.sort()
        length = len(candidates)
        
        
        for i in range(length):
            if (candidates[i]==target):
                final_list.append([candidates[i]])
            elif (candidates[i]<target):

                sub_list = [candidates[i]]
                value_list = sub_list[:]

                for j in range(i+1,length):

                    total = sum(value_list)+candidates[j]
                
                    if (total==target):

                        value_list.append(candidates[j])
                        final_list.append(value_list)
                        



                    elif(total<target):

                        if(j+1<length and total+candidates[j+1]<=target):
                            value_list.append(candidates[j])
                    
                    elif(total>target):
                        value_list = sub_list[:]
        final_list.sort()
        

        return [final_list[i] for i in range(len(final_list)) if i==0 or final_list[i]!=final_list[i-1]]


sol = Solution()
print sol.combinationSum2([1,1],2)

