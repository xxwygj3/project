package com.sbtest.projectjdbc.test.SortAndSearch;

public class Sorting<T extends Comparable<T>> {
    /**
     * 选择排序法(按升序排序)
     * 外层循环控制下一个最小值将存储在数组中的哪个位置。
     * 内层循环通过扫描所有大于或等于外层循环指定索引的位置来找出剩余列表的最小值。
     * 在确定出最小值后，将其和存储在索引位置处的值相交换。
     *
     * @param data
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] data) {
        int min;
        T temp;
        for (int index = 0; index < data.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < data.length; scan++) {
                if (data[scan].compareTo(data[min]) < 0) {
                    min = scan;
                }
            }
            temp = data[min];
            data[min] = data[index];
            data[index] = temp;
        }
    }

    /**
     * 插入排序法
     * 外层循环控制的是下一个插入值在数组中的索引。
     * 内层循环将当前插入值和存储在更小索引处的值进行比较（这就形成了整个列表的一个已排序子集）。
     * 如果当前插入值小于position的值，则将该值移位到右边。继续移位直到找到接收该插入值 的正确位置。
     *
     * @param data
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] data) {
        for (int index = 1; index < data.length; index++) {
            T key = data[index];
            //System.out.println("key="+key);
            int position = index;
            while (position > 0 && data[position - 1].compareTo(key) > 0) {
                data[position] = data[position - 1];//移位
                position--;
            }
            data[position] = key;
        }
    }

    /**
     * 冒泡排序法
     * 外层循环表示n-1轮数据遍历。
     * 内层循环将从头至尾扫描该数据，对相邻数据进行成对比较，如果必要则将它们互换。
     *
     * @param data
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] data) {
        for (int position = data.length - 1; position >= 0; position--) {
            for (int scan = 0; scan <= position - 1; scan++) {
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    swap(data, scan, scan + 1);
                }
            }
        }
    }

    private static <T extends Comparable<? super T>> void swap(T[] data, int position_1, int position_2) {
        T temp = data[position_1];
        data[position_1] = data[position_2];
        data[position_2] = temp;
    }

    public static <T extends Comparable<T>> void quickSort(T[] data) {
        quickSort(data, 0, data.length - 1);
    }

    /**
     * 快速排序法
     * 一般策略如下：
     * 首先，选择一个列表元素作为分区元素。
     * 下一步，分割该列表，使得小于该分区元素的所有元素位于该元素的左边，所有大于该分区元素的元素位于右边。
     * 最后，将该快速排序策略（递归式）应用于两个分区。
     *
     * @param data
     * @param min
     * @param max
     * @param <T>
     */
    private static <T extends Comparable<? super T>> void quickSort(T[] data, int min, int max) {
        if (min < max) {
            int indexofpartition = partition(data, min, max);//将排序区域分割成两个分区
            quickSort(data, min, indexofpartition - 1);//两次递归调用来对两个分区进行排序
            quickSort(data, indexofpartition + 1, max);
        }
    }

    /**
     * 返回分区元素值的索引
     *
     * @param data
     * @param min
     * @param max
     * @param <T>
     * @return
     */
    private static <T extends Comparable<? super T>> int partition(T[] data, int min, int max) {
        T partitionelement;
        int left;
        int right;
        int middle = (min + max) / 2;
        partitionelement = data[middle];
        swap(data, middle, min);

        left = min;
        right = max;
        while (left < right) {
            //第一个循环从左边扫描到右边，以寻找大于分区元素的元素
            while (left < right && data[left].compareTo(partitionelement) <= 0) {
                left++;
            }
            //第二个循环从右边扫描到左边，以寻找小于分区元素的元素
            while (data[right].compareTo(partitionelement) > 0) {
                right--;
            }
            if (left < right) {
                swap(data, left, right);
            }
        }
        swap(data, min, right);
        return right;
    }

    /**
     * 归并排序法
     * 一般策略如下：
     * 首先将该列表分成两个大约相等的部分，然后对每一部分列表递归调用其自身。
     * 继续该列表的递归分解，直至达到该递归的基本情形，
     * 这时该列表被分割成长度为1的列表，根据定义，它是已排序的了。
     * 然后，随着程序控制权传回至该递归调用结构，
     * 该算法将两个递归调用所产生的那两个排序子列表归并成一个排序列表。
     *
     * @param data
     * @param <T>
     */
    public static <T extends Comparable<T>> void mergeSort(T[] data) {
        mergeSort(data, 0, data.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] data, int min, int max) {
        if (min < max) {
            int mid = (min + max) / 2;
            mergeSort(data, min, mid);
            mergeSort(data, mid + 1, max);
            merge(data, min, mid, max);
        }
    }

    /**
     * 重组数组
     *
     * @param data
     * @param first
     * @param mid
     * @param last
     * @param <T>
     */
    private static <T extends Comparable<T>> void merge(T[] data, int first, int mid, int last) {
        T[] temp = (T[]) (new Comparable[data.length]);
        int first1 = first;
        int last1 = mid;
        int first2 = mid + 1;
        int last2 = last;
        int index = first1;
        while (first1 <= last1 && first2 <= last2) {
            if (data[first1].compareTo(data[first2]) < 0) {
                temp[index] = data[first1];
                first1++;
            } else {
                temp[index] = data[first2];
                first2++;
            }
            index++;
        }
        while (first1 <= last1) {
            temp[index] = data[first1];
            first1++;
            index++;
        }
        while (first2<=last2){
            temp[index] = data[first2];
            first2++;
            index++;
        }
        for(index=first;index<=last;index++){
            data[index]=temp[index];
        }
    }
}
