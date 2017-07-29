# Source : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
# Author : zhaohaiyuan
# Date   : 2017-07-29

######################################################################################## 
 #
 # Given an array of integers that is already sorted in ascending order, find two 
 # numbers such that they add up to a specific target number.
 # 
 # The function twoSum should return indices of the two numbers such that they add up to 
 # the target, where index1 must be less than index2. Please note that your returned 
 # answers (both index1 and index2) are not zero-based.
 # 
 # You may assume that each input would have exactly one solution and you may not use the 
 # same element twice.
 # 
 # Input: numbers={2, 7, 11, 15}, target=9
 # Output: index1=1, index2=2

########################################################################################

'''
idea: 
when we traverse the first num, we can determine if second num eixst by binary search.
so time complexity can reduce from O(n2) to O(nlogn). 
however, without other optimization, the time limit stll excceeded.
optimization: if we can't find the solution in nth index and numbers[n] == numbers[n+1],
we can traverse to n+2 directly

'''

class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        size = len(numbers)
        if size <= 1:
            return []
        if numbers[0] > target:
            return []

        last_index = size-1
            
        previous_first_num = None
        for index in range(0, last_index):
            first_index = index
            first_num = numbers[first_index]                     
            if first_num != previous_first_num:
                second_num = target - first_num
                if (second_num >= first_num and second_num >= numbers[first_index+1] and second_num <= numbers[last_index]):
                    second_index_tmp = self.binary_search(numbers[first_index+1:], second_num)
                    if second_index_tmp != -1:
                        second_index = second_index_tmp + index + 1
                        return [first_index+1, second_index+1]
            previous_first_num = first_num
        return []


    def binary_search(self, numbers, target):
        left = 0
        right = len(numbers) - 1

        while left >= 0 and left <= right:
            middle = int((left + right)/2)
            if numbers[middle] == target:
                return middle
            elif numbers[middle] > target:
                right = middle - 1
            else:
                left = middle + 1
        return -1

