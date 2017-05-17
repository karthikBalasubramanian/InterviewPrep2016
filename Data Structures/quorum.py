
images = [
{'width': 100,  'height': 80, 'src': 'kitty1.jpg'},
{'width': 10,  'height': 20, 'src': 'kitty2.jpg'},
{'width': 150, 'height': 60, 'src': 'kitty3.jpg'},
{'width': 10,  'height': 5, 'src': 'kitty4.jpg'},
{'width': 40,  'height': 20, 'src': 'kitty5.jpg'},
{'width': 60,  'height': 40, 'src': 'kitty6.jpg'},
]
max_row_width = 200
row_height = 40

def make_into_rows(images, max_row_width, row_height):
    
    for image in images:
        if(row_height > image['height']):
            diff_per  = (row_height-image['height'])/float(image['height'])
            image['width'] += diff_per* image['width']
            
        elif(row_height<image['height']):
            diff_per  = (image['height'] - row_height)/float(image['height'])
            image['width'] -= diff_per* image['width']   
        else:
            continue

        image['height'] = row_height
        
    final_list = []
    cum_sum = 0
    
    # while(counter<len(images)):
    #     curr_list = []
    #     print counter
    #     while(cum_sum+images[counter]['width']<max_row_width):
    #         print counter,images[counter]['src']
    #         cum_sum+= cum_sum+images[counter]['width']
    #         curr_list.append(images[counter])
    #         counter+=1
    #     counter-=1
    #     final_list.append(curr_list)
    #     cum_sum=0
    append_list = []
    for i in range(len(images)):
    	
    	if(cum_sum+images[i]['width']>max_row_width):
    		final_list.append(append_list)
    		append_list=[]
    		
    		cum_sum=(0+images[i]['width'])
    		
    	else:
    		cum_sum+=images[i]['width']
    		

    	append_list.append(images[i])
    print final_list

    
        

#  python permutation function
import itertools
def permute(nums):
    return map(list, itertools.permutations(nums))


print permute([1,2,3,4])