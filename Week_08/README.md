学习笔记



#### 快速排序

时间复杂度一般为O(nlogn)，最坏情况下会达到O(n^2)

```java
public static void quickSort(int[] arr, int begin, int end) {
    if (end <= begin) {
        return;
    }
    int pivot = partition(arr, begin, end);
    quickSort(arr, begin, pivot - 1);
    quickSort(arr, pivot + 1, end);
}

public static int partition(int[] arr, int begin, int end) {
    int pivot = end, counter = begin;
    // 将小于基准值的元素依次放到起始位置
    for (int i = being; i < end; i++) {
        if (arr[i] < arr[pivot]) {
            int tmp = arr[i];
            arr[i] = arr[counter];
            arr[counter] = tmp;
            counter++;
        }
    }
    // 经过上面的操作后counter前面的就都是比基准值小的了，将基准值的位置调整到应该在的位置上
    int tmp = arr[couter];
    arr[counter] = arr[prvot];
    arr[pivot] = tmp;
    return counter;
}
```

#### 归并排序

```java
public static void mergeSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) >> 1;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }

    // 相当于合并两个有序数据
    private static void merge(int[] arr, int begin, int mid, int end) {
        // 合并的两个有序数组后的大小
        int[] tmp = new int[end - begin + 1];
        int i = begin, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            tmp[k++] = arr[i] > arr[j] ? arr[j++] : arr[i++];
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= end) {
            tmp[k++] = arr[j++];
        }
        for (int p = 0; p < tmp.length; p++) {
            arr[begin + p] = tmp[p];
        }
    }

```

