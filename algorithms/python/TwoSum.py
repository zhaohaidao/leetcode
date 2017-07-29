# Source : https://leetcode.com/problems/two-sum
# Author : zhaohaiyuan
# Date   : 2017-07-27

######################################################################################## 
 # Given an array of integers, return indices of the two numbers such that they 
 # add up to a specific target.
 # 
 # You may assume that each input would have exactly one solution, and you may not use 
 # the same element twice.
 # 
 # Example:
 # 
 # Given nums = [2, 7, 11, 15], target = 9,
 # 
 # Because nums[0] + nums[1] = 2 + 7 = 9,
 # return [0, 1].

def twoSum(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    size = len(nums)
    if size <2:
        return []
    first_num = 0
    second_num = 1
    for first_index in range(0, size):
        for second_index in range(first_index + 1, size):
            if nums[first_index] + nums[second_index] == target:
                return [first_index, second_index]
    return []

print twoSum([2, 7, 11, 15], 9)

