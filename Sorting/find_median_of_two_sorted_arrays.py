#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # nums1 = nums1+nums2

        #  we can do it better. will do in a while
        target = []
        i =0
        j=0
        while(i<len(nums1) and j<len(nums2)):
            if(nums1[i]<nums2[j]):
                target.append(nums1[i])
                i+=1
            else:
                target.append(nums2[j])
                j+=1
            

        if(i<len(nums1)):
            target.extend(nums1[i:])

            
        if(j<len(nums2)):
            target.extend(nums2[j:])

        length = len(target)
        if(length%2!=0):
            return target[length//2]
        else:
            return (target[(length-1)//2]+target[((length-1)//2)+1])/float(2)  
        
        

sol = Solution()
print sol.findMedianSortedArrays([1,3],[2])