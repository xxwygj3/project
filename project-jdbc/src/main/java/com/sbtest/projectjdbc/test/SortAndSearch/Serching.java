package com.sbtest.projectjdbc.test.SortAndSearch;

public class Serching<T extends Comparable<T>> {
    /**
     * 线性查找法
     * @param data
     * @param min
     * @param max
     * @param target
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> boolean linearSearch(T[] data, int min, int max, T target) {
        int index = min;
        boolean found = false;
        while (!found && index <= max) {
            if (data[index].compareTo(target) == 0) {
                found=true;
            }
            index++;
        }
        return found;
    }

    /**
     * 二分查找法
     * 二分查找法将利用了查找池是已排序的这一事实。
     * 二分查找的每次比较都会删除一半的可行候选项。
     * 递归实现的
     * @param data
     * @param min
     * @param max
     * @param target
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>>boolean binarySearch(T[] data, int min, int max, T target){
        boolean found =false;
        int midpoint =(min+max)/2;//中点索引
        if(data[midpoint].compareTo(target)==0){
            found = true;
        }else if(data[midpoint].compareTo(target)>0){
            if(min<=midpoint-1){
                found=binarySearch(data,min,midpoint-1,target);
            }
        }else if(midpoint+1 <=max){
            found=binarySearch(data,midpoint+1,max,target);
        }
        return found;
    }
}
