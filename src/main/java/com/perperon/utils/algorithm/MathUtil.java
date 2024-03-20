package com.perperon.utils.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dupengcheng
 * @date 2024-03-20
 * @apiNote 算法工具类
 */
public class MathUtil {

    /**
     * 冒泡排序
     * @param arr
     * @return arr
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // Change flag
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * @param arr
     * @return arr
     */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * @param arr
     * @return arr
     */
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex -= 1;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    /**
     * 希尔排序
     *
     * @param arr
     * @return arr
     */
    public static int[] shellSort(int[] arr) {
        int n = arr.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int current = arr[i];
                int preIndex = i - gap;

                // 插入排序
                // Insertion sort
                while (preIndex >= 0 && arr[preIndex] > current) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }

                // 将当前元素插入到正确的位置
                arr[preIndex + gap] = current;
            }

            // 缩小步长
            gap /= 2;
        }
        return arr;
    }


    /**
     * 归并排序
     *
     * @param arr
     * @return arr
     */
    public static int[] mergeSort(int[] arr) {
        // 如果数组长度小于等于1，则直接返回原数组
        if (arr.length <= 1) {
            return arr;
        }
        // 找到数组的中间位置
        int middle = arr.length / 2;
        // 将数组分为两部分
        int[] arr_1 = Arrays.copyOfRange(arr, 0, middle);
        int[] arr_2 = Arrays.copyOfRange(arr, middle, arr.length);
        // 递归对两部分进行归并排序，并将结果合并
        return merge(mergeSort(arr_1), mergeSort(arr_2));
    }


    /**
     * 合并两个已排序的数组
     *
     * @param arr_1 第一个数组
     * @param arr_2 第二个数组
     * @return sorted_arr 合并后的已排序数组
     */
    public static int[] merge(int[] arr_1, int[] arr_2) {
        // 创建一个新的数组用于存储合并后的结果
        int[] sorted_arr = new int[arr_1.length + arr_2.length];
        // 定义三个索引，分别表示新数组的索引、arr_1的索引和arr_2的索引
        int idx = 0, idx_1 = 0, idx_2 = 0;
        // 当arr_1和arr_2都还有元素时，进行比较和赋值
        while (idx_1 < arr_1.length && idx_2 < arr_2.length) {
            // 如果arr_1的当前元素小于arr_2的当前元素
            if (arr_1[idx_1] < arr_2[idx_2]) {
                // 将arr_1的当前元素赋值给新数组
                sorted_arr[idx] = arr_1[idx_1];
                // arr_1的索引加1
                idx_1 += 1;
            } else {
                // 否则将arr_2的当前元素赋值给新数组
                sorted_arr[idx] = arr_2[idx_2];
                // arr_2的索引加1
                idx_2 += 1;
            }
            // 新数组的索引加1
            idx += 1;
        }
        // 如果arr_1还有剩余元素，将其全部赋值给新数组
        if (idx_1 < arr_1.length) {
            while (idx_1 < arr_1.length) {
                sorted_arr[idx] = arr_1[idx_1];
                idx_1 += 1;
                idx += 1;
            }
        } else {
            // 如果arr_2还有剩余元素，将其全部赋值给新数组
            while (idx_2 < arr_2.length) {
                sorted_arr[idx] = arr_2[idx_2];
                idx_2 += 1;
                idx += 1;
            }
        }
        // 返回合并后的已排序数组
        return sorted_arr;
    }



    /**
     *  快速排序
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] array, int low, int high) {
        // 选择最后一个元素作为基准值
        int pivot = array[high];
        // 指针指向数组的第一个元素
        int pointer = low;
        // 遍历数组，将小于等于基准值的元素放到指针的左边
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                // 交换当前元素和指针指向的元素
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                // 指针右移
                pointer++;
            }
            // 输出当前数组的状态
            System.out.println(Arrays.toString(array));
        }
        // 将基准值放到指针的位置
        int temp = array[pointer];
        array[pointer] = array[high];
        array[high] = temp;
        // 返回基准值的位置
        return pointer;
    }

    public static void quickSort(int[] array, int low, int high) {
        // 如果low小于high，则继续递归排序
        if (low < high) {
            // 对数组进行划分，得到划分元素的位置
            int position = partition(array, low, high);
            // 对划分元素左边的子数组进行递归排序
            quickSort(array, low, position - 1);
            // 对划分元素右边的子数组进行递归排序
            quickSort(array, position + 1, high);
        }
    }



    /** 堆排序
     * Heap Sort
     * @param arr
     * @return
     */
    public static int[] heapSort(int[] arr) {
        // 堆的结束索引
        // index at the end of the heap
        heapLen = arr.length;

        // 构建最大堆
        // build MaxHeap
        buildMaxHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            // 依次将堆顶元素与堆尾元素交换
            // Move the top of the heap to the tail of the heap in turn
            swap(arr, 0, i);

            // 堆的长度减1
            heapLen -= 1;

            // 对堆进行调整
            heapify(arr, 0);
        }

        return arr;
    }

    // Global variable that records the length of an array;
    static int heapLen;

    /**
     * Swap the two elements of an array
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 构建最大堆
     * @param arr
     */
    private static void buildMaxHeap(int[] arr) {
        // 从最后一个非叶子节点开始遍历到根节点
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            // 对每个节点进行堆化操作
            heapify(arr, i);
        }
    }


    /**
     * 调整为最大堆
     *
     * @param arr 数组
     * @param i   当前节点索引
     */
    private static void heapify(int[] arr, int i) {
        // 左子节点索引
        int left = 2 * i + 1;
        // 右子节点索引
        int right = 2 * i + 2;
        // 最大节点索引
        int largest = i;

        // 如果右子节点存在且大于当前最大节点
        if (right < heapLen && arr[right] > arr[largest]) {
            // 更新最大节点索引
            largest = right;
        }

        // 如果左子节点存在且大于当前最大节点
        if (left < heapLen && arr[left] > arr[largest]) {
            // 更新最大节点索引
            largest = left;
        }

        // 如果最大节点不是当前节点，则交换节点，并递归地对交换后的子树进行调整
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, largest);
        }
    }



    /**
     * 计数排序
     *
     * @param arr 待排序的数组
     * @return 排序后的数组
     */
    public static int[] countingSort(int[] arr) {
        // 如果数组长度小于2，则直接返回原数组
        if (arr.length < 2) {
            return arr;
        }

        // 获取数组中的最小值和最大值
        int[] extremum = getMinAndMax(arr);
        int minValue = extremum[0];
        int maxValue = extremum[1];

        // 初始化计数数组，长度为最大值与最小值的差加1
        int[] countArr = new int[maxValue - minValue + 1];

        // 初始化结果数组，长度与原数组相同
        int[] result = new int[arr.length];

        // 遍历原数组，统计每个元素出现的次数
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - minValue] += 1;
        }

        // 计算每个元素及其之前所有元素出现的总次数
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }

        // 从后往前遍历原数组，根据计数数组确定每个元素在结果数组中的位置，并更新计数数组
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = countArr[arr[i] - minValue] - 1;
            result[idx] = arr[i];
            countArr[arr[i] - minValue] -= 1;
        }

        // 返回排序后的结果数组
        return result;
    }

    /**
     * 获取数组中的最大值和最小值
     *
     * @param arr 数组
     * @return 包含最大值和最小值的数组
     */
    private static int[] getMinAndMax(int[] arr) {
        // 初始化最大值为数组的第一个元素
        int maxValue = arr[0];
        // 初始化最小值为数组的第一个元素
        int minValue = arr[0];
        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
            // 如果当前元素大于最大值，则更新最大值
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
            // 如果当前元素小于最小值，则更新最小值
            else if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }
        // 返回包含最大值和最小值的数组
        return new int[] { minValue, maxValue };
    }




    /**
     * Bucket Sort 桶排序
     * @param arr 待排序的整数列表
     * @return 排序后的整数列表
     */
    public static List<Integer> bucketSort(List<Integer> arr, int bucket_size) {
        // 如果待排序的列表长度小于2，或者桶的大小为0，则直接返回原列表
        if (arr.size() < 2 || bucket_size == 0) {
            return arr;
        }
        // 获取列表中的最小值和最大值
        int[] extremum = getMinAndMax(arr);
        int minValue = extremum[0];
        int maxValue = extremum[1];
        // 计算桶的数量
        int bucket_cnt = (maxValue - minValue) / bucket_size + 1;
        // 初始化桶的列表
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucket_cnt; i++) {
            buckets.add(new ArrayList<Integer>());
        }
        // 将待排序的元素放入对应的桶中
        for (int element : arr) {
            int idx = (element - minValue) / bucket_size;
            buckets.get(idx).add(element);
        }
        // 对每个非空的桶进行递归排序
        for (int i = 0; i < buckets.size(); i++) {
            if (buckets.get(i).size() > 1) {
                buckets.set(i, bucketSort(buckets.get(i), bucket_size / 2));
            }
        }
        // 将排序后的桶中的元素合并到结果列表中
        ArrayList<Integer> result = new ArrayList<>();
        for (List<Integer> bucket : buckets) {
            for (int element : bucket) {
                result.add(element);
            }
        }
        // 返回排序后的结果列表
        return result;
    }

    /**
     * 获取数组中的最大值和最小值
     *
     * @param arr 数组
     * @return 包含最大值和最小值的数组
     */
    private static int[] getMinAndMax(List<Integer> arr) {
        // 初始化最大值为数组的第一个元素
        int maxValue = arr.get(0);
        // 初始化最小值为数组的第一个元素
        int minValue = arr.get(0);

        // 遍历数组中的每个元素
        for (int i : arr) {
            // 如果当前元素大于最大值，则更新最大值
            if (i > maxValue) {
                maxValue = i;
            } else if (i < minValue) {
                // 如果当前元素小于最小值，则更新最小值
                minValue = i;
            }
        }

        // 返回包含最大值和最小值的数组
        return new int[] { minValue, maxValue };
    }




    /**
     * 基数排序
     *
     * @param arr 待排序的数组
     * @return 排序后的数组
     */
    public static int[] radixSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        // 初始化基数N为1
        int N = 1;
        // 获取数组中的最大值
        int maxValue = arr[0];
        for (int element : arr) {
            if (element > maxValue) {
                maxValue = element;
            }
        }

        // 计算最大值的位数，确定需要排序的轮数
        while (maxValue / 10 != 0) {
            maxValue = maxValue / 10;
            N += 1;
        }

        // 对数组进行N轮排序
        for (int i = 0; i < N; i++) {
            // 创建10个桶，用于存放每个位上的数字
            List<List<Integer>> radix = new ArrayList<>();
            for (int k = 0; k < 10; k++) {
                radix.add(new ArrayList<Integer>());
            }

            // 将数组中的元素按照当前位上的数字放入对应的桶中
            for (int element : arr) {
                int idx = (element / (int) Math.pow(10, i)) % 10;
                radix.get(idx).add(element);
            }

            // 将桶中的元素按照顺序放回数组中
            int idx = 0;
            for (List<Integer> l : radix) {
                for (int n : l) {
                    arr[idx++] = n;
                }
            }
        }

        return arr;
    }


}
