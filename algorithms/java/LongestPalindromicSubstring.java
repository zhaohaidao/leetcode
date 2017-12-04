// Source : https://leetcode.com/problems/longest-palindromic-substring
// Author : zhaohaiyuan
// Date   : 2017-12-05

/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example:
 *
 * Input: "babad"
 *
 * Output: "bab"
 *
 * Note: "aba" is also a valid answer.
 * Example:
 *
 * Input: "cbbd"
 *
 * Output: "bb"
 *
 */

/*
 * Solition:
 * 1) Brute Force: O(n3), obviously Time Limit Exceeded
 * 2) DP:  
 *	P(i, j) = s[i]=s[j] && P(i+1, j-1)
 *	P(i, i) = true
 *	P(i, i+1) = P(i, i) && s[i] = s[i+1]
 *
 *      followed code is base on DP, however python edtion TLE either!
 *
 */

class Solution {
    public String longestPalindrome(String s) {
        int size = s.length();
        if (size < 2) {
            return s;
        } else if (size == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        } else {
            boolean[][] palindromeRecord = new boolean[size][size];
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; i++) {
                palindromeRecord[i][i] = true;
            }
            for (int i = 0; i < size-1; i++) {
                palindromeRecord[i][i+1] = palindromeRecord[i][i] && s.charAt(i) == s.charAt(i+1);
                if (palindromeRecord[i][i+1] && end-start<1) {
                    start = i;
                    end = i+1;
                }
            }
            for (int subSize = 3; subSize < size+1; subSize++) {
                for (int i=0; i<size+1-subSize; i++) {
                    palindromeRecord[i][i+subSize-1] = s.charAt(i) == s.charAt(i+subSize-1) &&
                            palindromeRecord[i+1][i+subSize-2];
                    if (palindromeRecord[i][i+subSize-1] && subSize > end-start) {
                        if (start != i) {
                            start = i;
                        }
                        if (end != i+subSize-1) {
                            end = i+subSize-1;
                        }
                    }
                }
            }
            return s.substring(start, end+1);            
        }
              
    }
}
