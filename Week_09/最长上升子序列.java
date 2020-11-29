// 300. 最长上升子序列

class Solution {
    public int lengthOfLIS(int[] nums) {
        // tails[i]表示子序列为i + 1长度时的末尾元素
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tails[end]) {
                end++;
                tails[end] = nums[i];
            } else {
                // 从头tails数组中找到第一个大于nums[i]的位置并替换
                int left = 0, right = end;
                while (left < right) {
                    int mid = (left + right) >>> 1;
                    if (nums[i] > tails[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tails[left] = nums[i];
            }
        }
        end++;
        return end;
    }
}