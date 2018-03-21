/*
How many numbers III?

Нужно сгенерировать все числа из трех цифр, которые состоят из:

Цифр от 1 до 9.
Цифры идут в порядке возрастания.
Числа, которые подходят под указанные выше условия: 118, 127, 136, 145, 226, 235, 244, 334

Вам нужно написать функцию, которая получает 2 аргумента:

Сумма цифр числа.
Количество цифр в числе.

Функция должна выводить массив с тремя значениями:

Сумма всех возможных комбинаций.
Минимальное число
Максимальное число

Вход / Выход
findAll(10, 3)   -   [8, "118", "334"]
findAll(27, 3)   -   [1, "999", "999"]
findAll(84, 4)   -   []
findAll(35, 6)   -   [123, '116999', '566666']
 */

import java.util.Arrays;
import java.util.TreeSet;

public class Juniorlab19 {

    public static int[] findAll(int n, int k) {
        int counter = 0;
        int minNumber = 1;
        int maxNumber = 1;
        TreeSet<Integer> treeSet = new TreeSet<>();
        // определяю диапазон чисел
        for (int i = 0; i < k; i++) {
            maxNumber *= 10;
        }
        minNumber = maxNumber / 10;
        maxNumber -= 1;
        String tempNumberAsString;
        for (int i = minNumber; i <= maxNumber; i++) {
            tempNumberAsString = "" + i;
            if (tempNumberAsString.contains("0")) { // в числах не должно быть цифры 0
                tempNumberAsString = tempNumberAsString.replace("0", "1");
                i = Integer.parseInt(tempNumberAsString) - 1;
                continue;
            }
            boolean writeNumber = false;
            int[] arrayForDigit = new int[k];
            int tempNumber = i;
            // разбиваю число на разряды
            for (int j = k - 1; j >= 0; j--) {
                arrayForDigit[j] = tempNumber % 10;
                tempNumber /= 10;
            }
            // цифры в числе должны идти в порядке возрастания
            for (int j = 0; j < k - 1; j++) {
                if (arrayForDigit[j] <= arrayForDigit[j + 1]) {
                    writeNumber = true;
                } else {
                    writeNumber = false;
                    break;
                }
            }
            // сумма разрядов должна совпадать с заданной (n)
            if (writeNumber) {
                int sumDigits = 0;
                for (int j = 0; j < k; j++) {
                    sumDigits += arrayForDigit[j];
                }
                // если совпало, то сохраняем число
                if (sumDigits == n) {
                    String clearNumber = Arrays.toString(arrayForDigit);
                    clearNumber = clearNumber.replaceAll("[, \\[\\]]", "");
                    treeSet.add(Integer.parseInt(clearNumber));
                    counter++;
                }
            }
        }
        int result[] = new int[0];
        if (counter > 1) {
            result = new int[]{counter, treeSet.first(), treeSet.last()};
        } else if (counter == 1) {
            result = new int[]{counter, treeSet.first(), treeSet.first()};
        }
        //System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int example01 = 35;
        int example02 = 6;
        int example11 = 10;
        int example12 = 3;
        int example21 = 27;
        int example22 = 3;
        int example31 = 84;
        int example32 = 4;

        System.out.println(Arrays.toString(findAll(example01, example02))); //{123, 116999, 566666}
        System.out.println(Arrays.toString(findAll(example11, example12))); //{8, 118, 334}
        System.out.println(Arrays.toString(findAll(example21, example22))); //{1, 999, 999}
        System.out.println(Arrays.toString(findAll(example31, example32))); //{}
    }
}
