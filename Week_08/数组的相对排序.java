// 1122. 数组的相对排序

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int n : arr1) {
            upper = Math.max(upper, n);
        }
        int[] count = new int[upper + 1];
        for (int n : arr1) {
            count[n]++;
        }
        int i = 0;
        for (int n : arr2) {
            while (count[n] != 0) {
                arr1[i++] = n;
                count[n]--;
            }
            count[n] = 0;
        }
        for (int j = 0; j <= upper; j++) {
            while (count[j] != 0) {
                arr1[i++] = j;
                count[j]--;
            }
            count[j] = 0;
        }
        return arr1;
    }
}