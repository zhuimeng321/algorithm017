#### [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)

```java
// 时间复杂度为；O(N);空间复杂度为:O(1)
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] ca = new int[26];
    for (int i = 0; i < s.length(); i++) {
        ca[s.charAt(i) - 'a'] ++;
        ca[t.charAt(i) - 'a'] --;
    }
    for (int i = 0; i < ca.length; i++) {
        if (ca[i] != 0) {
            return false;
        }
    }
    return true;
}
```

#### [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)

```java
// 时间复杂度O(NK)；空间复杂度为：O(NK),其中N为strs数组的大小，K为数组元素字符串最长的长度
public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
        return new ArrayList<>();
    }
    HashMap<String, List> map = new HashMap<>();
    for (String s : strs) {
        char[] ca = new char[26];
        for (char c : s.toCharArray()) {
            ca[c - 'a']++;
        }
        String key = String.valueOf(ca);
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<List<String>>());
        }
        map.get(key).add(s);
    }
    return new ArrayList(map.values());
}
```

#### [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

```java
// 时间复杂度: O(N);空间复杂度:O(N)
public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
        return new int[0];
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target - nums[i])) {
            return new int[]{map.get(target-nums[i]), i};
        }
        map.put(nums[i], i);
    }
    return null;
}
```

#### [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

```java
// 时间复杂度:O(n),空间复杂度:O(n)
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    inorder(root, ans);
    return ans;
}
public void inorder(TreeNode root, List<Integer> ans) {
    if (root == null) {
        return;
    }
    inorder(root.left, ans);
    ans.add(root.val);
    inorder(root.right, ans);
}
```

#### [144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

```java
// 时间复杂度:O(n),空间复杂度:O(n)
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    preorder(root, ans);
    return ans;
}

public void preorder(TreeNode root, List<Integer> list) {
    if (root == null) {
        return;
    }
    list.add(root.val);
    preorder(root.left, list);
    preorder(root.right, list);
}
```

#### [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)

```java
// 时间复杂度:O(NlogK)；空间复杂度：O(N)
public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<int[]> heap = new PriorityQueue<>(
        (nums1,nums2) -> {return nums1[1] - nums2[1];});
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int num = entry.getKey();
        int count = entry.getValue();
        if (heap.size() == k) {
            if (heap.peek()[1] < count) {
                heap.poll();
                heap.offer(new int[]{num, count});
            }
        } else {
            heap.offer(new int[]{num, count});
        }
    }
    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
        ans[i] = heap.poll()[0];
    }
    return ans;
}
```

