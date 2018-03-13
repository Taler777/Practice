/*
Нужно напистаь функцию, которое возвращает количество конечных нулей в факториале переданного числа.
Вход / Выход
12   -  2
1000000000   -   249999998
100000   -   24999
1000   -   249
100   -   24
30   -   7
6   -   1


Подсказка:
Число пар из двоек и пятерок равно количеству нулей в конце. Закройте глаза на все, что осталось слева от нулей.
В целом слева у вас останется двойка или пятерка, для которых не нашлось пары. Обычно это двойки.
Более того, когда вы имеете дело с факториалом, это всегда двойки.
(В факториалах имеется больше четных множителей, чем множителей, которые делятся на 5.)
Поэтому узким местом является число пятерок. Из этого следует,
что вопрос можно сформулировать по-другому: сколько раз N! можно разделить без остатка на 5?

 */

public class Juniorlab14 {

    public static int zeros(int n) {
        int result = 0;
        for (int divider = 5; divider <n; divider*=5) {
            result += n /divider;
        }
        return result;
    }

    public static void main(String[] args) {
        int example01 = 12;
        int example11 = 1000000000;
        int example21 = 100000;
        int example31 = 1000;
        int example41 = 100;
        int example51 = 30;
        int example61 = 6;

        System.out.println(zeros(example01));
        System.out.println(zeros(example11));
        System.out.println(zeros(example21));
        System.out.println(zeros(example31));
        System.out.println(zeros(example41));
        System.out.println(zeros(example51));
        System.out.println(zeros(example61));
    }
}
