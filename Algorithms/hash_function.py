#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian

from collections import OrderedDict
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


sol = Solution()
print sol.isAnagram('ab','a')
sol.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"])
print sol.lengthOfLongestSubstring('abcabcbb')