package Sorts;

import static Sorts.SortUtils.*;

/**
 * Implementation of gnome sort
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @since 2018-04-10
 **/

/**
 * @author Dc
 * 地精排序
 * 当标志有效且 i >(<) i+1 时交换，否则不交换
 * 只要交换   i = i - 1
 * 只要补交换 i = i + 1
 *
 */
public class GnomeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int i = 1;
        int j = 2;
        while (i < arr.length) {
            if (less(arr[i - 1], arr[i]))
                i = j++;
            else {
                swap(arr, i - 1, i);
                if (--i == 0)
                    i = j++;
            }
        }


        return arr;
    }

    private void gnome(Integer[] array) {
        int i = -1;
        while (i < array.length - 1) {
            if (i != -1 && array[i] > array[i + 1])
                swap(array,i + 1,i --);
            else i ++;
        }
    }

    public static void main(String[] args) {
        Integer[] integers = {4, 23, 6, 78, 1, 26, 11, 23, 0, -6, 3, 54, 231, 9, 12};
        String[] strings = {"c", "a", "e", "b", "d", "dd", "da", "zz", "AA", "aa", "aB", "Hb", "Z"};
        GnomeSort gnomeSort = new GnomeSort();

//        gnomeSort.sort(integers);
        gnomeSort.gnome(integers);

        gnomeSort.sort(strings);

        System.out.println("After sort : ");
        print(integers);
        print(strings);


    }

}
