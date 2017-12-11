// Source : https://leetcode.com/problems/subsets-ii
// Author : zhaohaiyuan
// Date   : 2017-12-11

/*
 * enumrate all the substring by recursion, say you have three digits, all the possible subsets( 1 means include this digit, 0 means not) are as follows
 * skip exist one, however, recursion should be continued
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
    public List<List<Integer>> subsetsWithDup(int[] S) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<List<Integer>> duplicates = new HashSet<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(S);
        res.add(tmp);
        dfs(duplicates, res, tmp, S, 0);
        return res;
    }

    public void dfs(Set<List<Integer>> duplicates, List<List<Integer>> res, List<Integer> tmp, int[] S, int pos) {
        if (pos <= S.length - 1) {
            List<Integer> subset = new ArrayList<Integer>(tmp);
            subset.add(S[pos]);
            if (!duplicates.contains(subset)) {
                duplicates.add(subset);
                res.add(subset);               
            }             
            tmp.add(S[pos]);                                
            dfs(duplicates, res, tmp, S, pos + 1);
            tmp.remove(tmp.size() - 1);
            dfs(duplicates, res, tmp, S, pos + 1);                                
            
        }
    }
}

