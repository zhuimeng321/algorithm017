// 621. 任务调度器

// 1.找到单个类型任务最多的那个设定为max（可能有多个类型的任务个数相同maxCount），
//任务中间插入n个空隙，会产生max - 1个空隙区域,每个空隙区域的长度为 n - (maxCount - 1) 
// 剩余的任务向这些空隙中插入
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0, maxCount = 0;
        for (char task : tasks) {
            count[task - 'A']++;
            if (max == count[task - 'A']) {
                maxCount++;
            }
            if (max < count[task - 'A']) {
                max = count[task - 'A'];
                maxCount = 1;
            }
        }
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;
    }
}