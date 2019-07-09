package Sorts;

import static Sorts.SortUtils.*;


/**
 * Comb Sort algorithm implementation
 * <p>
 * Best-case performance O(n * log(n))
 * Worst-case performance O(n ^ 2)
 * Worst-case space complexity O(1)
 * <p>
 * Comb sort improves on bubble sort.
 *
 * @author Sandeep Roy (https://github.com/sandeeproy99)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see BubbleSort
 * @see SortAlgorithm
 */

/**
 * @author Dc
 * 梳排序
 * 递减率(步长)：1.3
 * 长度除以1.3，从第0个元素开始，跟距离当前元素为步长大小的元素进行比较交换，直到比较到最后一个元素为止
 * 将步长除以1.3，继续上述步骤
 */
class CombSort implements SortAlgorithm {

    // To find gap between elements
    private int nextGap(int gap) {
        // Shrink gap by Shrink factor
        gap = (gap * 10) / 13;
        return (gap < 1) ? 1 : gap;
    }

    /**
     * Function to sort arr[] using Comb
     *
     * @param arr - an array should be sorted
     * @return sorted array
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T arr[]) {
        int size = arr.length;

        // initialize gap
        int gap = size;

        // Initialize swapped as true to make sure that loop runs
        boolean swapped = true;     //int swapped = 1;

        // Keep running while gap is more than 1 and last iteration caused a swap
        while (gap != 1 || swapped) {   // swapped > 0
            // Find next gap
            gap = nextGap(gap);

            // Initialize swapped as false so that we can check if swap happened or not
            // boolean or int 都可以，用于控制是否进入下次循环。
            swapped = false;    // swapped = 0;

            // Compare all elements with current gap
            for (int i = 0; i < size - gap; i++) {
                if (less(arr[i + gap], arr[i])) {
                    // Swap arr[i] and arr[i+gap]
                    swapped = swap(arr, i, i + gap);   // swapped += 1 ;
                }
            }
        }
        return arr;
    }

    private void combSort(Integer[] array) {

        int gap = array.length;
        boolean swapped = true;

        while (gap != 1 || swapped) {
            gap = ((gap * 10) / 13) < 1 ? 1 : (gap * 10) / 13;
            swapped = false;
            for (int i = 0; i < array.length - gap; i ++) {
               if (array[i+gap] < array[i]) {
                   int swap = array[i];
                   array[i] = array[i+gap];
                   array[i+gap] = swap;
                   swapped = true;
               }
           }
        }
    }

    // Driver method
    public static void main(String args[]) {
        CombSort ob = new CombSort();
        Integer[] arr = {8, 4, 1, 56, 3, -44, -1, 0, 36, 34, 8, 12, -66, -78, 23, -6, 28, 0};
        ob.combSort(arr);

        System.out.println("sorted array");
        print(arr);
    }
}
