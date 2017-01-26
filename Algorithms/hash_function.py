#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

import collections
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        s_dict={}
        for index,value in enumerate(list(s)):
        	if value in s_dict:
        		s_dict[value]=s_dict[value]+1
        	else:
        		s_dict[value]=1

        for index,value in enumerate(list(t)):
        	if value in s_dict:
        		s_dict[value]-=1
        	else:
        		return False
        for i in s_dict.values():
        	if i!=0:
        		return False
        return True


    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        if len(strs)==0:
        	return []

        dict_strs = {}
        for index,value in enumerate(strs):
        	new_key = "".join(sorted(value))
        	if new_key in dict_strs:
        		dict_strs[new_key].append(value)
        	else:
        		dict_strs[new_key]=[value]

        return dict_strs.values()


    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        # pwwkew
        # Given a string, find the length of the longest substring without repeating characters
        # Given "abcabcbb", the answer is "abc", which the length is 3.
        

       	# print position_dict
       	print s
       	end_pos =0
       	all_sub_strings = []
       	for i in range(len(s)):
       		for j in range(i+1,len(s)):
       			if s[j]==s[i]:
       				print s[j],s[i]

       				end_pos=j
       				break
       		print end_pos
       		all_sub_strings.append(s[i:end_pos])

       	return all_sub_strings

    def checkElementsEven(self,myList):
      return [i%2 for i in myList]


    def canPermutePalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # check the length of the string
        # if even there should be all pairs.
        # if odd there should be all but one pairs.

        # lenStr = len(s)
        countDict = collections.Counter(s)
        checkCount = self.checkElementsEven(countDict.values())
        if(sum(checkCount)<2):
            return True
        else:
            return False
        
        # if(lenStr%2==0):
        #   if(sum(checkCount)==0):
        #     return True
        #   else:
        #     return False
        # else:
        #   if(sum(checkCount)==1):
        #     return True
        #   else:
        #     return False
          
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        pass


    # def findAnagrams(self, s, p):
    #     """
    #     :type s: str
    #     :type p: str
    #     :rtype: List[int]
    #     """
    #     final_list = []
    #     p = sorted(p)
    #     lenp = len(p)
    #     for index,value in enumerate(s):
    #       if (sorted(s[index:index+lenp]) == p):
    #         final_list.append(index)

    #     return final_list

    def findAnagrams(self, s, p):
      """
      :type s: str
      :type p: str
      :rtype: List[int]
      """
      if len(s) < len(p):
          return []
      dic = {}
      for c in p:
          dic[c] = dic.get(c,0) + 1
    
      print dic
      res = []
      start_idx = 0
      local = {}
      for idx,c in enumerate(s):
        if idx < len(p):
          local[c] = local.get(c,0) + 1
        else:
            
            if local == dic:
                
                res.append(start_idx)
            #updates dic
            local[s[start_idx]] -= 1
            print local
            if local[s[start_idx]] == 0:
                del local[s[start_idx]]
            local[c] = local.get(c,0) + 1
            start_idx += 1
    #deal with last one
      if local == dic:
          res.append(start_idx)
    
      print res

sol = Solution()
# print sol.isAnagram('ab','a')
# sol.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"])
# print sol.lengthOfLongestSubstring('abcabcbb')
sol.canPermutePalindrome("code")
sol.findAnagrams("cbaebabacd","abc")
