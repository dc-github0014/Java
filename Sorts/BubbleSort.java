package Sorts;

import static Sorts.SortUtils.*;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 */

/**
 * @author Dc
 * 冒泡排序
 * 从头遍历所有相邻的元素 取最大(小)值进行调换位置，
 * 遍历一次找出一个最大 (小)值放在末尾，重复以上步骤
 *
 *  do while：
 *  for for：
 *
 *  时间复杂度：O(n * n/2) = O(n?)
 *
 */
class BubbleSort implements SortAlgorithm {
    /**
     * This method implements the Generic Bubble Sort
     *
     * @param array The array to be sorted
     *              Sorts the array in increasing order
     **/

    @Override
    public <T extends Comparable<T>> T[] sort(T array[]) {
        int last = array.length;
        //Sorting
        boolean swap;
        do {
            swap = false;
            for (int count = 0; count < last - 1; count++) {
                if (less(array[count], array[count + 1])) {
                    swap = swap(array, count, count + 1);
                }
            }
            last--;
        } while (swap);
        return array;
    }

    private void sortDoubleFor(Integer[] array) {

        for (int j = 0; j < array.length - 1; j++) {
            for (int k = 0; k < array.length - 1 - j; k++) {
                if (array[k] > array[k+1]) {
                    int tmp = array[k];
                    array[k] = array[k+1];
                    array[k+1] = tmp;
                }
            }
        }
    }

    // Driver Program
    public static void main(String[] args) {

        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(integers);
        // Output => 231, 78, 54, 23, 12, 9, 6, 4, 1
        print(integers);

        Integer[] array = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        bubbleSort.sortDoubleFor(array);
        print(array);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        //Output => e, d, c, b, a
        print(bubbleSort.sort(strings));

    }
}
