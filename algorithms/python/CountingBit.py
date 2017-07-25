# Source : https://leetcode.com/problems/counting-bits
# Author : zhaohaiyuan
# Date   : 2017-07-25

######################################################################################## 
 #
 # Discuss
 #           
 #           
 #           
 #           
 #             Pick One
 #           
 #         
 #         
 #         
 #       
 #       
 #       
 #         Given a non negative integer number num. For every numbers i in the range 0 
 # ≤ i ≤ num calculate the number of 1's in their binary representation and return them 
 # as an array.
 # 
 # Example:
 # For num = 5 you should return [0,1,1,2,1,2].
 # 
 # Follow up:
 # 
 # It is very easy to come up with a solution with run time O(n*sizeof(integer)). But 
 # can you do it in linear time O(n) /possibly in a single pass?
 # Space complexity should be O(n).
 # Can you do it like a boss? Do it without using any builtin function like 
 # __builtin_popcount  in c++ or in any other language.
 # 
 # Credits:Special thanks to @ syedee  for adding this problem and creating all test 
 # cases.
 #       
 #       
 #       
 #       
 #         
 #         
 #           
 #         
 #         
 #           
 #           
 #           
 #           
 #           
 #           
 #           
 #           
 #         
 #         
 #           
 #             Seen this question in a real interview before?  
 #             
 #             
 #             
 #           
 #           
 #             When did you encounter this question?  
 #             
 #             
 #             
 #           
 # 
 #           
 #             Which company?  
 #             
 #             
########################################################################################
# digit    binary
# 0           0
# 1           1
# 2          10
# 3          11
# 4         100
# 5         101
# 6         110
# 7         111
# 8        1000

# from the above table, we can find the following rule 
# count_0 = 0, count_1= 1
# count_2 = 1 + count_0, count_3 = 1 + count_1
# count_4 = 1 + count_0, count_5 = 1 + count_1, count_6 = 1 + count_2, count_7 = 1 + count_3
# ...
# the caculated data can be reused. The caculation is as followed.
# count_n = 1 + (n % pow(2, int(log(2, n))))
# right part just want to know which data to reuse.
# actually, we can figure it out faster: n & (n-1)

class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        import math
        if num< 0:
            return []
        elif num == 0:
            return [0]
        elif num == 1:
            return [0, 1]
        else:
            bits_list = [0] * (num+1)
            bits_list[0] = 0
            bits_list[1] = 1
            for offset in range(2, num+1):
	    bits_list[offset] = 1 + bits_list[offset & (offset - 1)]
        return bits_list

