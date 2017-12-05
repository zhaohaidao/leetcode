// Source : https://leetcode.com/problems/longest-palindromic-substring
// Author : zhaohaiyuan
// Date   : 2017-12-05

/*
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input:
 *
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 * Input:
 *
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 *
 */

/*
 * Solution: reversed s to s' and compute longest subsequence between s and s'
 */

class Solution {
    public int longestPalindromeSubseq(String s) {
        String reversedS = new StringBuffer(s).reverse().toString();
        int size = s.length();
        int[][]longestSize = new int[size+1][size+1];
        for (int i = 0; i < size; i++) {
            longestSize[i][0]=0;
            longestSize[0][i]=0;
        }
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (s.charAt(i-1)==reversedS.charAt(j-1)) {
                    longestSize[i][j] = longestSize[i-1][j-1] + 1;
                } else {
                    longestSize[i][j] = Math.max(longestSize[i-1][j], longestSize[i][j-1]);
                }
            }
        }
        return longestSize[size][size];
    }
}
