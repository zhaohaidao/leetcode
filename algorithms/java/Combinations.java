// Source : https://leetcode.com/problems/combinations
// Author : zhaohaiyuan
// Date   : 2017-12-11

/*
 * Solution: dfs+backtracking
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combos = new ArrayList<List<Integer>>();
        List<Integer> combo = new ArrayList<Integer>();
        dfs(n, combos, combo, 1, k);
        return combos;
    }

    public void dfs(int n, List<List<Integer>> combos, List<Integer> combo, int pos, int kDelta) {
        if (kDelta == 0) {
            combos.add(new ArrayList<Integer>(combo));
            return;
        }
        for (int i = pos; i <= n - kDelta + 1; i++) {
            combo.add(i);
            dfs(n, combos, combo, i + 1, kDelta - 1);
            combo.remove(combo.size() - 1);
        }
    }
}

