/*
Snail

Вам дан массив n на n. Верните массив, в котором элементы расположены по следующему порядку:
от внешних элементов к центру по часовой стрелке.
Пустая матрица 0 на 0 должна вернуть пустой массив.

Вход / Выход
[[1,2,3],[4,5,6],[7,8,9]]   -   [1,2,3,6,9,8,7,4,5]
[[1,2,3],[8,9,4],[7,6,5]]   -   [1,2,3,4,5,6,7,8,9]

 */

import java.util.Arrays;

public class Juniorlab33 {
    public static int[] snail(int[][] array) {
        int size = array.length;
        int result[] = new int[0];

        if (array.length > 0 && array[0].length > 0) {
            result = new int[size * size];
            int count = 0;
            int m; // количество проходов
            if (size % 2 == 0) {
                m = size / 2;
            } else {
                m = size / 2 + 1;
            }
            for (int i = 0; i < m; i++) {
                for (int j = i; j < size - i; j++) { // вправо
                    result[count] = array[i][j];
                    count++;
                }

                for (int j = i + 1; j < size - i; j++) { // вниз
                    result[count] = array[j][size - i - 1];
                    count++;
                }

                for (int j = size - i - 2; j >= i; j--) { // влево
                    result[count] = array[size - i - 1][j];
                    count++;
                }

                for (int j = size - i - 2; j > i; j--) { //наверх
                    result[count] = array[j][i];
                    count++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] example01 = {{1, 2, 3, 4, 5, 6}, {20, 21, 22, 23, 24, 7}, {19, 32, 33, 34, 25, 8}, {18, 31, 36, 35, 26, 9}, {17, 30, 29, 28, 27, 10}, {16, 15, 14, 13, 12, 11}};
        int[][] example21 = {{1}};
        int[][] example31 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] example41 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] example11 = {{}};

        System.out.println(Arrays.toString(snail(example01))); // {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36}
        System.out.println(Arrays.toString(snail(example11))); // {}
        System.out.println(Arrays.toString(snail(example21))); // {1}
        System.out.println(Arrays.toString(snail(example31))); // {1, 2, 3, 6, 9, 8, 7, 4, 5}
        System.out.println(Arrays.toString(snail(example41))); // {1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12, 13}
    }
}
