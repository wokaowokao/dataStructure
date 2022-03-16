package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangyawei Created on 2022/3/12.
 * 参考：https://www.cnblogs.com/guoyaohua/p/8600214.html
 * https://www.nowcoder.com/discuss/857931?type=all&order=recall&pos=&page=1&ncTraceId=&channel=-1&source_id=search_all_nctrack&gio_id=F6D80479ACBD6B95C2E82C9A830A4293-1647092411007
 */
public class Sort {
    int[] nums = {3, 2, 4, 5, 1, 10, 8, 5, 3, 324, 121, 2};

    {
        print00();
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void print00() {
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 最简单的实现
     * [3, 2, 4, 5, 1, 10, 8, 5, 3, 324, 121, 2]
     * [1, 3, 4, 5, 2, 10, 8, 5, 3, 324, 121, 2]
     * [1, 2, 4, 5, 3, 10, 8, 5, 3, 324, 121, 2]
     * [1, 2, 2, 5, 4, 10, 8, 5, 3, 324, 121, 3]
     * [1, 2, 2, 3, 5, 10, 8, 5, 4, 324, 121, 3]
     * [1, 2, 2, 3, 3, 10, 8, 5, 5, 324, 121, 4]
     * [1, 2, 2, 3, 3, 4, 10, 8, 5, 324, 121, 5]
     * [1, 2, 2, 3, 3, 4, 5, 10, 8, 324, 121, 5]
     * [1, 2, 2, 3, 3, 4, 5, 5, 10, 324, 121, 8]
     * [1, 2, 2, 3, 3, 4, 5, 5, 8, 324, 121, 10]
     * [1, 2, 2, 3, 3, 4, 5, 5, 8, 10, 324, 121]
     * [1, 2, 2, 3, 3, 4, 5, 5, 8, 10, 121, 324]
     * [1, 2, 2, 3, 3, 4, 5, 5, 8, 10, 121, 324]
     * [1, 2, 2, 3, 3, 4, 5, 5, 8, 10, 121, 324]
     */
    @Test
    public void lowSort() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(i, j);
                }
            }
            print00();
        }
        print00();
    }

    /**
     * 冒泡
     * [3, 2, 4, 5, 1, 10, 8, 5, 3, 324, 121, 2]
     * [2, 3, 4, 1, 5, 8, 5, 3, 10, 121, 2, 324]
     * [2, 3, 1, 4, 5, 5, 3, 8, 10, 2, 121, 324]
     * [2, 1, 3, 4, 5, 3, 5, 8, 2, 10, 121, 324]
     * [1, 2, 3, 4, 3, 5, 5, 2, 8, 10, 121, 324]
     * [1, 2, 3, 3, 4, 5, 2, 5, 8, 10, 121, 324]
     * [1, 2, 3, 3, 4, 2, 5, 5, 8, 10, 121, 324]
     * [1, 2, 3, 3, 2, 4, 5, 5, 8, 10, 121, 324]
     * [1, 2, 3, 2, 3, 4, 5, 5, 8, 10, 121, 324]
     * [1, 2, 2, 3, 3, 4, 5, 5, 8, 10, 121, 324]
     * [1, 2, 2, 3, 3, 4, 5, 5, 8, 10, 121, 324]
     * [1, 2, 2, 3, 3, 4, 5, 5, 8, 10, 121, 324]
     * [1, 2, 2, 3, 3, 4, 5, 5, 8, 10, 121, 324]
     */
    @Test
    public void bubbleSort() {
        boolean notExchanged = true;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    notExchanged = false;
                    swap(j, j + 1);
                }
            }
            if (notExchanged) break;
            print00();
        }
        print00();
    }


    /**
     * 简单选择
     * 查找下标最小值，和下标值替换。
     * [3, 2, 4, 5, 1, 10, 8, 5, 3, 324, 121, 2]
     * [1, 2, 4, 5, 3, 10, 8, 5, 3, 324, 121, 2]
     * [1, 2, 4, 5, 3, 10, 8, 5, 3, 324, 121, 2]
     * [1, 2, 2, 5, 3, 10, 8, 5, 3, 324, 121, 4]
     * [1, 2, 2, 3, 5, 10, 8, 5, 3, 324, 121, 4]
     * [1, 2, 2, 3, 3, 10, 8, 5, 5, 324, 121, 4]
     * [1, 2, 2, 3, 3, 4, 8, 5, 5, 324, 121, 10]
     * [1, 2, 2, 3, 3, 4, 5, 8, 5, 324, 121, 10]
     * [1, 2, 2, 3, 3, 4, 5, 5, 8, 324, 121, 10]
     * [1, 2, 2, 3, 3, 4, 5, 5, 8, 324, 121, 10]
     * [1, 2, 2, 3, 3, 4, 5, 5, 8, 10, 121, 324]
     * [1, 2, 2, 3, 3, 4, 5, 5, 8, 10, 121, 324]
     * [1, 2, 2, 3, 3, 4, 5, 5, 8, 10, 121, 324]
     */
    @Test
    public void selectSort() {
        int min, minIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            min = nums[i];
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (min != nums[i]) {
                nums[minIndex] = nums[i];
                nums[i] = min;
            }
            print00();
        }
        print00();
    }

    /**
     * 插入排序，类似打牌，摸到手里的是有序的
     */
    @Test
    public void insertSort() {
        int card;
        for (int i = 1; i < nums.length; i++) {
            card = nums[i];
            for (int j = i - 1; j >= 0; j++) {
                if (nums[j] > card) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[i - 1] = card;
        }
    }

    /**
     * 希尔排序
     * gap 数组长度一半，不断减半。
     * 06 17 28..两两排序，之后分成2组有序。
     * i 从gap累加到最大长度。
     */
    @Test
    public void ShellSort() {
        int len = nums.length;
        int gap = len / 2;
        int temp;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = nums[i];
                int preIndex = i - gap;
                //  gap 6 i 6  preIndex 0
                //preIndex 和 i 值比较
                while (preIndex >= 0) {
                    if (nums[preIndex] > temp) {
                        nums[preIndex + gap] = nums[preIndex];
                        preIndex -= gap;
                    } else break;
                }
                nums[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        print00();
    }

    /**
     * 归并排序
     */
    @Test
    public void MergeSort() {
        int[] ints = MergeSort(nums);
        System.out.println(Arrays.toString(ints));
    }

    private int[] MergeSort(int[] nums) {
        if (nums.length < 2) return nums;
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(MergeSort(left), MergeSort(right));
    }

    /**
     *
     */
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

    @Test
    public void quickSort() {
        int[] ints = quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 快速排序方法
     */
    private int[] quickSort(int[] array, int start, int end) {
        if (array.length < 1 || start > end) return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            quickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            quickSort(array, smallIndex + 1, end);
        return array;
    }

    /**
     * 3 2 4 1 5  -> 以 3 为基准,左边比它小,右边比它大
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] array, int start, int end) {
        int i = start, j = end, pivot = start;
        while (i <= j) {
            while (i <= j && array[i] <= array[pivot]) {
                i++;
            }
            while (i <= j && array[j] > array[pivot]) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, pivot, j);
        return j;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    public void heapSort() {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 从nums[half]到nums[0]构建大顶堆
        // 从没有儿子的节点开始，维持大顶堆性质
        int half = nums.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(nums, nums.length, i);
        }
        print00();
        //[324, 121, 10, 5, 3, 4, 8, 5, 3, 1, 2, 2]
    }


    private void maxHeap(int[] nums, int heapSize, int curr) {
        int left = curr * 2 + 1;
        int right = left + 1;
        System.out.println("curr:" + curr);
        System.out.println("left:" + left);
        System.out.println("right:" + right);
        System.out.println();

        // max(自己，左儿子，右儿子)
        int maxIndex = curr;
        if (left < heapSize && nums[left] > nums[maxIndex]) {
            maxIndex = left;
        }
        if (right < heapSize && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }
        // 如果找到大儿子，则替换，并继续向下探
        if (curr != maxIndex) {
            swap(nums, curr, maxIndex);
            // maxHeap(nums, heapSize, maxIndex);
        }
    }
}
