/*
Task
Вам задан массив, который содержит целые числа.
Массив полностью состоит из целых четных или нечетных чисел, за исключением одного числа N.
Напишите метод, который принимаем массив, как аргумент и возвращает число N.

Например,
Вход [2, 4, 0, 100, 4, 11, 2602, 36] - выход 11
Вход [160, 3, 1719, 19, 11, 13, -21] - выход 160
 */

public class Juniorlab1 {

    public static int findOutlier(int[] integers) {
        int indexEven = 0;
        int indexUneven = 0;
        int even = 0;
        int uneven = 0;
        int index = 0;
        for (int j = 0; j < integers.length; j++) {
            if (integers[j] % 2 == 0) {
                even++;
                indexEven = j;
            } else {
                uneven++;
                indexUneven = j;
            }
            if (even > 0 && uneven > 0) {
                if ((even > uneven) && j > 1) {
                    index = indexUneven;
                    break;
                } else if ((even < uneven) && j > 1) {
                    index = indexEven;
                    break;
                }
            }
        }
        System.out.println(integers[index]);
        return integers[index];
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 0, 100, 4, 11, 2602, 36};
        int[] array2 = {160, 3, 1719, 19, 11, 13, -21};
        int[] array3 = {11, 2, 4, 0, 100, 4, 22, 2602, 36};
        int[] example01 = {-1021455, 125454543, 1211212, 1412312145, -1212453};
        int[] example11 = {1, 2, 3};
        int[] example21 = {2, 4, 6, 8, 10, 3};
        int[] example31 = {0, 0, 3, 0, 0};
        int[] example41 = {1, 1, 0, 1, 1};
        int[] example51 = {13, 17, 99, 8, 15};
        findOutlier(array);
        findOutlier(array2);
        findOutlier(array3);
        System.out.println("---------------------");
        findOutlier(example01);
        findOutlier(example11);
        findOutlier(example21);
        findOutlier(example31);
        findOutlier(example41);
        findOutlier(example51);
    }
}

