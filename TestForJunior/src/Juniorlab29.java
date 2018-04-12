/*
Rectangle into Squares

Рисунок ниже показывает, как можно разрезать прямоугольник на квадраты.

rectangle
Нужно придумтаь из этого рисунка алгоритм.

Вам даны две величины:

Длина прямоугольника (параметр lng)
Ширина прямоугольника (параметр width)
Вы должны вернуть массив чисел с размером стороны каждого квадрата.

Если передаваемые аргументы равны, то вернуть null.

Вход / Выход
sqInRect(5, 3)   -   [3, 2, 1, 1]
sqInRect(3, 5)   -   [3, 2, 1, 1]
sqInRect(5, 5)   -   null
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Juniorlab29 {

    public static int[] sqInRect(int lng, int wdth) {
        ArrayList <Integer> arrayList = new ArrayList<>();
        if (lng == wdth) {
            return null;
        } else {
            do {
                if (lng > wdth) {
                    lng -= wdth;
                    arrayList.add(wdth);
                } else {
                    wdth-=lng;
                    arrayList.add(lng);
                }
                if (lng==wdth ){
                    arrayList.add(lng);
                }
            } while (lng != wdth);
        }
        return arrayList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int example01 = 6;
        int example02 = 6;
        int example11 = 5;
        int example12 = 5;
        int example21 = 5;
        int example22 = 3;
        int example31 = 3;
        int example32 = 5;
        int example41 = 20;
        int example42 = 14;
        int example51 = 240;
        int example52 = 32;
        int example61 = 135;
        int example62 = 85;

        System.out.println(Arrays.toString(sqInRect(example01, example02))); // null
        System.out.println(Arrays.toString(sqInRect(example11, example12))); // null
        System.out.println(Arrays.toString(sqInRect(example21, example22))); // {3, 2, 1, 1}
        System.out.println(Arrays.toString(sqInRect(example31, example32))); // {3, 2, 1, 1}
        System.out.println(Arrays.toString(sqInRect(example41, example42))); // {14, 6, 6, 2, 2, 2}
        System.out.println(Arrays.toString(sqInRect(example51, example52))); // {32, 32, 32, 32, 32, 32, 32, 16, 16}
        System.out.println(Arrays.toString(sqInRect(example61, example62))); // {85, 50, 35, 15, 15, 5, 5, 5}
    }
}
