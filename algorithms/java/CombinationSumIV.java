// Source : https://leetcode.com/problems/combinations-sum-iv
// Author : zhaohaiyuan
// Date   : 2017-12-11

/*
 * dfs+backtracking will lead to TLE
 * so we use recursion + memo
 */

class Solution {
    public int combinationSum4(int[] candidates, int target) {
        List<List<Integer>> combos = new ArrayList<List<Integer>>();
        List<Integer> combo = new ArrayList<Integer>();
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return helper(memo, candidates, target);
    }

    public int helper(Map<Integer, Integer> memo, int[] candidates, int target) {
        if (memo.get(target) != null) {
            return memo.get(target);
        } else {
            int sum = 0;
            for (int i = 0; i < candidates.length; i++) {
                int delta = target - candidates[i];
                if (delta > 0) {
                    sum += helper(memo, candidates, delta);
                } else if (delta == 0) {
                    sum += 1;
                }
            }
            memo.put(target, sum);
            return sum;
        }
    }
}
