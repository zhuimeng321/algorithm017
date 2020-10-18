class Solution {
	// 时间复杂度：O(n*n!) 空间复杂度为：O(n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrace(ans, new ArrayList<>(), new HashSet<>(), nums);
        return ans;
    }
    public void backtrace(List<List<Integer>> ans, List<Integer> tmpList, HashSet tmpSet, int[] nums){
        if (tmpList.size() == nums.length) {
            ans.add(new ArrayList<>(tmpList));
            return; 
        }
        for(int i = 0; i < nums.length; i++) {
            if (tmpSet.contains(nums[i])) continue;
            tmpSet.add(nums[i]);
            tmpList.add(nums[i]);
            backtrace(ans, tmpList, tmpSet, nums);
            tmpSet.remove(tmpList.get(tmpList.size() - 1));
            tmpList.remove(tmpList.size() - 1);
        }
    }
}