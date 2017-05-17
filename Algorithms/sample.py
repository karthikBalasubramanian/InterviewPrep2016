#!/home/bks4line/anaconda2/bin/python
# Author: Karthik Balasubramanian
import re
record_num = 0

headers = dict()

regex_date = re.compile(r"[A-Z]\s[A-Z]\s[A-Z]\s{3}.*$")
regex_key = re.compile(r"([A-Z/]+):\s(.*)$")

input = '''N O V   2 3 R D
ABS: HELLO
KEY: DUMMY
asfnaldnfklasf

J A N   3 R D
ABS/: HELLO
KEY/: DUMMY
asfnaldnfklasf

ABS: 24134

ABS/: HI
KEY: gaina

'''

all_lines = input.splitlines()

i = 0

while (i < len(all_lines)):
    
        if (re.match(regex_date,all_lines[i])):
            
            date = all_lines[i]
            
            i+=1
            
            print(date)
            
            while (i < len(all_lines) and not re.match(regex_date,all_lines[i])): 
                                               
                if(re.match(regex_key,all_lines[i])):
            
                    key = re.match(regex_key,all_lines[i]).group(1)
                    val = re.match(regex_key,all_lines[i]).group(2)
                                        
                    if key not in headers.keys():
                        headers[key] = [""]*record_num
                    
                    if (len(headers[key]) != record_num):
                        headers[key].extend([""]*(record_num - len(headers[key])))
                    
                    headers[key].insert(record_num,val)  
                    
                elif (all_lines[i].strip() != ""):
                                        
                    key = re.match(regex_key,all_lines[i-1]).group(1)
                    val = re.match(regex_key,all_lines[i-1]).group(2)                  
                                       
                    val = val + " " + all_lines[i]
                                        
                    headers[key][record_num] = val
                    
                      
                else:
                                       
                    if "DATE" not in headers.keys():
                        headers["DATE"] = list()
                      
                    
                    headers["DATE"].insert(record_num, date)
                    record_num+=1

                    
                i+=1                    
                
    
    
all_keys = sorted(headers.keys())
print 
# for i in all_keys:
#     if i!="DATE":
#         print all_keys