#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian


def print_str_array(arr):
    for i in range(len(arr)):
            print arr[i]
    

def  missingWords(s, t):
    s = s.split()
    t = t.split()
    if len(t)==0:
        print_str_array(s)    
    else:
        j=0
        for i in range(len(s)):
            if (s[i]==t[j]):
                j+=1 
                if j==len(t):
                    print_str_array(s[i+1:])
                    break   
            else:
                print s[i]

# def  buildSubsequences( s):
    
#     result_list = []
#     length = len(s)
#     for i  in range(2**length):
#         final_list = []
#         for j in range(length):
#             if (i & (1<<j)):
#                 final_list.append(j)

#         result_list.append("".join(final_list))
#         result_word_list.append()
#     return result_list

# missingWords("hello hello","hello")

# buildSubsequences("abc")

def  rearrangeWord(word):
    char_list =  list(word)
    char_list.map(lambda x:ord(x))
    # for i in range(len(char_list)-1,0,-1):
    #     if(ord(char_list[i])<ord(char_list[i-1])):
    #         temp =char_list[i]
    #         char_list[i]= char_list[i-1]
    #         char_list[i-1]= temp
    #         break
    # return "".join(char_list)


rearrangeWord("hefg")