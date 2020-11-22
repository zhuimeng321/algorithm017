// 56. 合并区间

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        // sort by start postion
        Arrays.sort(intervals, (v1, v2) -> {return v1[0] - v2[0];});

        int[] newInterval = intervals[0];
        List<int[]> list = new ArrayList<>();
        list.add(newInterval);
        for (int[] interval : intervals) {
            // 起始位置小于要比较的结束位置时说明两个区间有重合
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                list.add(interval);
                newInterval = interval;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}