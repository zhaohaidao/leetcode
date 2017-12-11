// Source : https://leetcode.com/problems/combinations-sum-iii
// Author : zhaohaiyuan
// Date   : 2017-12-11

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combos = new ArrayList<List<Integer>>();
        List<Integer> combo = new ArrayList<Integer>();
        dfs(n, combos, combo, 1, k);
        return combos;
    }

    public void dfs(int n, List<List<Integer>> combos, List<Integer> combo, int pos, int kDelta) {
        int sum = sum(combo);
        if (sum == n) {
            if (kDelta == 0) {
                combos.add(new ArrayList<Integer>(combo));
            }
        } else if (sum < n) {
            if (kDelta == 0) {
                return;
            }
            int max = Math.min(9, n - kDelta + 1);
            for (int i = pos; i <= max; i++) {
                if (sum + i <= n) {
                    combo.add(i);
                    dfs(n, combos, combo, i + 1, kDelta - 1);
                    combo.remove(combo.size() - 1);
                }
            }
        }
    }

    public int sum(List<Integer> combo) {
        int sum = 0;
        for (int i = 0; i < combo.size(); i++) {
            sum += combo.get(i);
        }
        return sum;
    }
}
