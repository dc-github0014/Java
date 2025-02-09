package Sorts;

import java.util.Random;

import static Sorts.SortUtils.print;


/**
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 */

/**
 * @author Dc
 * 猴子排序（恶搞）
 * 对集合内所有元素进行随机位置调换,直到有序为止
 */

public class BogoSort implements SortAlgorithm {

    private static final Random random = new Random();
    private static Integer time = 0;

    private static <T extends Comparable<T>> boolean isSorted(T array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            if (SortUtils.less(array[i + 1], array[i])) return false;
        }
        return true;
    }

    // Randomly shuffles the array
    private static <T> void nextPermutation(T array[]) {
        int length = array.length;

        for (int i = 0; i < array.length; i++) {
            int randomIndex = i + random.nextInt(length - i);
            SortUtils.swap(array, randomIndex, i);
        }
    }

    public <T extends Comparable<T>> T[] sort(T array[]) {
        while (!isSorted(array)) {
            nextPermutation(array);
            time += 1;
        }
        return array;
    }

    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        BogoSort bogoSort = new BogoSort();

        // print a sorted array
        SortUtils.print(bogoSort.sort(integers));
        print(time);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        SortUtils.print(bogoSort.sort(strings));
        print(time);
    }
}
