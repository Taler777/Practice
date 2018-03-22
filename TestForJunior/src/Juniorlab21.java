/*
Pascal's Triangle

Подробнее про треугольник Паскаля можно прочитать тут: http://en.wikipedia.org/wiki/Pascal's_triangle

Напишите функцию, которая принимает значение глубины треугольника и возвращает одномерный массив,
представляющий треугольник Паскаля.

Вход / Выход
4   -   [1,1,1,1,2,1,1,3,3,1]
 */


import java.util.ArrayList;
import java.util.Arrays;

public class Juniorlab21 {

    public static int[] pascalsTriangle(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int triangle[][] = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
                arrayList.add(triangle[i][j]);
            }
        }
        int[] result = arrayList.stream().mapToInt(i -> i).toArray();
        return result;
    }

    public static void main(String[] args) {
        int example01 = 10;
        int example11 = 1;
        int example21 = 2;
        int example31 = 4;
        int example41 = 6;

        System.out.println(Arrays.toString(pascalsTriangle(example01))); // { 1,   1,   1,   1,   2,   1,   1,   3,   3,   1,   1,   4,   6,   4,   1,   1,   5,   10,   10,   5,   1,   1,   6,   15,   20,   15,   6,   1,   1,   7,   21,   35,   35,   21,   7,   1,   1,   8,   28,   56,   70,   56,   28,   8,   1,   1,   9,   36,   84,   126,   126,   84,   36,   9,   1 }
        System.out.println(Arrays.toString(pascalsTriangle(example11))); // {1}
        System.out.println(Arrays.toString(pascalsTriangle(example21))); // {1,1,1}
        System.out.println(Arrays.toString(pascalsTriangle(example31))); // { 1, 1, 1, 1, 2, 1, 1, 3, 3, 1 }
        System.out.println(Arrays.toString(pascalsTriangle(example41))); // { 1, 1, 1, 1, 2, 1, 1, 3, 3, 1, 1, 4, 6, 4, 1, 1, 5, 10, 10, 5, 1 }
    }
}
