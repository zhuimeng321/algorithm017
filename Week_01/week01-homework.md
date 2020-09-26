#### [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

```java
// 时间复杂度：O(n) 空间复杂度：O(1)
public int removeDuplicates(int[] nums) {
        int i = 1, j = 0;
        while (i < nums.length) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
            i++;
        }
        return j + 1;
}
```

#### [189. 旋转数组](https://leetcode-cn.com/problems/rotate-array/)

```java
// 时间复杂度：O(n) 空间复杂度：O(1)
public void rotate(int[] nums, int k) {
    k = k % nums.length;
    reverse(nums, 0, nums.length-1);
    reverse(nums, 0, k -1);
    reverse(nums, k, nums.length-1);
}

public void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
        start++;
        end--;
    }
}
```

#### [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

```java
// 时间复杂度：O(m+n) 空间复杂度：O(m+n)
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     if (l1 == null) {
         return l2;
     } else if (l2 == null) {
         return l1;
     } else if (l1.val < l2.val) {
         l1.next = mergeTwoLists(l1.next, l2);
         return l1;
     } else {
         l2.next = mergeTwoLists(l1, l2.next);
         return l2;
     }
 }
```

#### [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

```java
// 时间复杂度：O(m+n) 空间复杂度: O(1)
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;
    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k--] = nums1[i--];
        } else {
            nums1[k--] = nums2[j--];
        }
    }
    while (j >= 0) {
        nums1[k--] = nums2[j--];
    }
}
```

#### [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

```java
// 时间复杂度：O(n) 空间复杂度：O(n)
public int[] twoSum(int[] nums, int target) {
    if (nums == null) {
        return null;
    }
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target - nums[i])) {
            result[1] = i;
            result[0] = map.get(target - nums[i]);
            return result;
        }
        map.put(nums[i], i);
    }
    return null;
}
```

#### [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)

```java
// 时间复杂度：O(n) 空间复杂度：O(1)
public void moveZeroes(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            nums[j] = nums[i];
            if (i != j) {
                nums[i] = 0;
            }
            j++;
        }
    }
}
```

#### [66. 加一](https://leetcode-cn.com/problems/plus-one/)

```java
// 时间复杂度：O(n) 空间复杂度：O(n)
public int[] plusOne(int[] digits) {
    for (int i = digits.length -1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i] = digits[i] + 1;
            return digits;
        }
        digits[i] = 0;
    }
    int[] result = new int[digits.length + 1];
    result[0] = 1;
    return result;
}
```

#### [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

```java
// 时间复杂度：O(n) 空间复杂度：O(1)
public boolean hasCycle(ListNode head) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = dummy.next;
    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;
}
```

