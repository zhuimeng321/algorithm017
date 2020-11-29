// 917. 仅仅反转字母

class Solution {
    public String reverseOnlyLetters(String S) {
        // 双指针法
        int n = S.length();
        int i = 0, j = n - 1;
        char[] arr = S.toCharArray();
        while (i < j) {
            if (!Character.isLetter(arr[i])) {
                i++;
            } else if (!Character.isLetter(arr[j])) {
                j--;
            } else {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}