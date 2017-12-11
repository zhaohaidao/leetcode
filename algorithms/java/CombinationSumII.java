// Source : https://leetcode.com/problems/combinations-sum-ii
// Author : zhaohaiyuan
// Date   : 2017-12-11

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combos = new ArrayList<List<Integer>>();
        List<Integer> combo = new ArrayList<Integer>();
        Set<List<Integer>> duplicates = new HashSet<List<Integer>>();
        Arrays.sort(candidates);
        dfs(candidates, duplicates, target, combos, combo, 0);
        return combos;
    }

    public void dfs(int[] candidates, Set<List<Integer>> duplicates, int target, List<List<Integer>> combos,
                    List<Integer> combo, int pos) {
        int sum = sum(combo);
        if (sum == target) {
            if (!duplicates.contains(combo)) {
                duplicates.add(combo);
                combos.add(new ArrayList<Integer>(combo));
            }
        } else if (sum < target) {
            for (int i = pos; i < candidates.length; i++) {
                if (sum + candidates[i] <= target) {
                    combo.add(candidates[i]);
                    dfs(candidates, duplicates, target, combos, combo, i + 1);
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

