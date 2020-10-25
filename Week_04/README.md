学习笔记

#### 1、搜索遍历特点

- 每个节点都要访问一次
- 每个节点仅仅要访问一次
- 对于节点的访问顺序不限
  - 深度优先
  - 广度优先

dfs模板

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
        return ans;
    }
    travel(root, 0, ans);
    return ans;
}

public void travel(TreeNode root, int level, List<List<Integer>> ans) {
    if (ans.size() == level) {
        ans.add(new ArrayList<>());
    }
    ans.get(level).add(root.val);
    if (root.left != null) {
        travel(root.left, level + 1, ans);
    }
    if (root.right != null) {
        travel(root.right, level + 1, ans);
    }
}
```

bfs模板

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
        return ans;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> results = new ArrayList<>();
        while (size-- > 0) {
            TreeNode node = queue.poll();
            results.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        ans.add(results);
    }
    return ans;
}
```

#### 2.贪心算法

- 贪心：当下做局部最优判断
- 回溯：能够回退
- 动态规划：最优判断+回退



#### 3.二分查找

二分查找前提：

- 目标函数单调性（单调递增或者递减）
- 存在上下界（bounded）
- 能够通过索引访问

```java

public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return -1;
}
```

