// Source : https://leetcode.com/problems/subsets
// Author : zhaohaiyuan
// Date   : 2017-12-11

/*
 * enumrate all the substring by recursive method, say you have three digits, all the possible subsets( 1 means include this digit, 0 means not) are as follows
 * 100
 * 101
 * 110
 * 111
 * 000
 * 001
 * 010
 * 011
 *
 */

class Solution {
    public List<List<Integer>> subsets(int[] S) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(S);
        res.add(tmp);
        dfs(res, tmp, S, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> tmp, int[] S, int pos) {
        if (pos <= S.length - 1) {
            tmp.add(S[pos]);
            res.add(new ArrayList<Integer>(tmp));
            dfs(res, tmp, S, pos + 1);
            tmp.remove(tmp.size() - 1);
            dfs(res, tmp, S, pos + 1);
        }
    }
}

