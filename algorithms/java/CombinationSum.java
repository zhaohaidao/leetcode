// Source : https://leetcode.com/problems/combinations-sum
// Author : zhaohaiyuan
// Date   : 2017-12-11

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combos = new ArrayList<List<Integer>>();
        List<Integer> combo = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, target, combos, combo, 0);
        return combos;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> combos, List<Integer> combo, int pos) {
        int sum = sum(combo);
        if (sum == target) {
            combos.add(new ArrayList<Integer>(combo));
        } else if (sum < target) {
            for (int i = pos; i < candidates.length; i++) {
                if (sum + candidates[i] <= target) {
                    combo.add(candidates[i]);
                    dfs(candidates, target, combos, combo, i);
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
