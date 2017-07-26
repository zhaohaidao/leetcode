# Source : https://leetcode.com/problems/first-missing-positive
# Author : zhaohaiyuan
# Date   : 2017-07-26

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
 #         
 # Given an unsorted integer array, find the first missing positive integer.
 # 
 # For example,
 # Given [1,2,0] return 3,
 # and [3,4,-1,1] return 2.
 # 
 # Your algorithm should run in O(n) time and uses constant space.
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

'''
We can move the num to the place whcih the index is the num.

for example, (considering the array is zero-based).
1 => A[1-1], 2 => A[2-1], 3=>A[3-1]

idea comes from StackOverflow.com:
http://stackoverflow.com/questions/1586858/find-the-smallest-integer-not-in-a-list

'''
def first_missing_positive(nums):
    size = len(nums)
    if size == 0:
        return 1
    for index in range(size):
        while (nums[index] <= size \
                and nums[index] > 0 \
                and nums[index] != index + 1 \
                and nums[nums[index]-1] != nums[index]):
            swap(nums, index, nums[index] - 1 )
    first_missing_positive = -1
    for index in range(size):
        if nums[index] != index + 1:
            return index+1
    return size + 1


def swap(nums, left_index, right_index):
    tmp = nums[left_index]
    nums[left_index] = nums[right_index]
    nums[right_index] = tmp
