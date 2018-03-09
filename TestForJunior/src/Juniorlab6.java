/*
Вам дан массив с числами. Нужно найти целое число, которое встречается нечетное число раз.
Такое число всегда будет только одно.
 */

import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.parallelSort;

public class Juniorlab6 {

    public static int findOdd(int[] arr) {
        int result = 0;
        parallelSort(arr); // отсортировать массив
        // упорядочить массив чисел и оставить только уникальные значения
        Map<Integer, Integer> treeMap = new TreeMap<>();
        for (int number : arr) {
            treeMap.put(number, 0);
        }
        // перебором посчитать число вхождения
        for (Map.Entry<Integer, Integer> pair : treeMap.entrySet()) {
            int counter = 0;
            int number = pair.getKey();
            for (int element : arr) {
                if (element == number) counter++;
            }
            if (counter % 2 != 0) {
                result = pair.getKey();
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] example01 = {5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10};
        int[] example11 = {20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5};
        int[] example21 = {1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5};
        int[] example31 = {20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5};
        int[] example41 = {10};
        int[] example51 = {1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1};

        System.out.println(findOdd(example01));
        System.out.println(findOdd(example11));
        System.out.println(findOdd(example21));
        System.out.println(findOdd(example31));
        System.out.println(findOdd(example41));
        System.out.println(findOdd(example51));
    }
}
