/*
Weight for weight

В качестве параметра функция принимает строку, содержащую числа, которые записаны через пробел.
Функция должна вернуть строку с этими же числами, но отсортированными в порядке возрастания по сумме цифр в числе.

Если два числа имеют одинаковый вес, то сортировать данные числа между собой надо так, как сортировали бы строки.

Вход / Выход

"56 65 74 100 99 68 86 180 90"   -   "100 180 90 56 65 74 68 86 99"
 */

import java.util.*;

public class Juniorlab30 {
    public static String orderWeight(String str) {
        String result = new String();
        String[] numbersAsString = str.split(" ");
        TreeSet<String> sameElementst = new TreeSet<>();
        // пузырьки
        for (int i = 0; i < numbersAsString.length; i++) {
            String temp;
            for (int j = 0; j < numbersAsString.length - i - 1; j++) {
                if (sumOfDigits(numbersAsString[j]) > sumOfDigits(numbersAsString[j + 1])) {
                    temp = numbersAsString[j + 1];
                    numbersAsString[j + 1] = numbersAsString[j];
                    numbersAsString[j] = temp;
                } else if (sumOfDigits(numbersAsString[j]) == sumOfDigits(numbersAsString[j + 1])) {
                    sameElementst.add(numbersAsString[j]);
                    sameElementst.add(numbersAsString[j + 1]);
                    numbersAsString[j] = sameElementst.first();
                    numbersAsString[j + 1] = sameElementst.last();
                    sameElementst.clear();
                }
            }
        }
        for (String number : numbersAsString) {
            result += number + " ";
        }
        result = result.trim();
        return result;
    }

    public static int sumOfDigits(String number) {
        int sum = 0;
        // перебираю строку по символам
        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i);
            if (num != 48) {
                sum += num - 48;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String example01 = "101798 38 189482 8 212143 32 453748 180 247782 134 321210 35 342441 182 268273 176 245559 184 9175 30 68";
        String example11 = "103 123 4444 99 2000";
        String example21 = "2000 10003 1234000 44444444 9999 11 11 22 123";
        String example31 = "10003 1234000 44444444 9999 2000 123456789";
        String example41 = "3 16 9 38 95 1131268 49455 347464 59544965313 496636983114762 85246814996697";
        String example51 = "320364 51 436967 37 239993 81 288235 49 145682 148 403470 197 213764 31 360047 178 99316 37 24615 157 49";
        String example61 = "32351 33 397776 78 251639 185 328760 15 202903 7 348160 189 482235 99 351936 90 228301 89 248758 135 63";
        String example71 = "270997 18 401567 195 469930 64 150209 86 391853 30 341360 45 456471 86 119722 158 248029 34 173474 6 15";

        System.out.println(orderWeight(example01)); // "30 32 134 35 8 180 321210 182 38 184 212143 176 68 342441 9175 101798 268273 245559 247782 453748 189482"
        System.out.println(orderWeight(example11)); // "2000 103 123 4444 99"
        System.out.println(orderWeight(example21)); // "11 11 2000 10003 22 123 1234000 44444444 9999"
        System.out.println(orderWeight(example31)); // "2000 10003 1234000 44444444 9999 123456789"
        System.out.println(orderWeight(example41)); // "3 16 9 38 95 1131268 49455 347464 59544965313 496636983114762 85246814996697"
        System.out.println(orderWeight(example51)); // "31 51 81 37 37 148 157 49 49 178 197 24615 320364 403470 360047 213764 145682 288235 99316 239993 436967"
        System.out.println(orderWeight(example61)); // "15 33 7 135 63 90 185 32351 78 202903 228301 89 189 99 348160 482235 251639 328760 351936 248758 397776"
        System.out.println(orderWeight(example71)); // "30 15 6 34 18 45 64 158 86 86 195 150209 341360 119722 401567 248029 173474 456471 391853 469930 270997"
    }
}
