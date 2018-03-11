/*
Sum Strings as Numbers

Даны две строки, которые содержат целые числа. Функция должна вернуть строку с суммой этих двух чисел.

Вход /  Выход

sumStrings('1', '2')   -   '3'
 */

import java.math.BigInteger;

public class Juniorlab9 {

    public static String sumStrings(String a, String b) {
        BigInteger number1 = new BigInteger(a);
        BigInteger number2 = new BigInteger(b);
        String result = "" + (number1.add(number2));
        return result;
    }

    public static void main(String[] args) {
        String example01 = "50095301248058391139327916261";
        String example02 = "81055900096023504197206408605";
        String example11 = "123";
        String example12 = "456";
        String example21 = "8797";
        String example22 = "45";
        String example31 = "800";
        String example32 = "9567";
        String example41 = "99";
        String example42 = "1";
        String example51 = "00103";
        String example52 = "08567";
        String example61 = "712569312664357328695151392";
        String example62 = "8100824045303269669937";

        System.out.println(sumStrings(example01, example02));
        System.out.println(sumStrings(example11, example12));
        System.out.println(sumStrings(example21, example22));
        System.out.println(sumStrings(example31, example32));
        System.out.println(sumStrings(example41, example42));
        System.out.println(sumStrings(example51, example52));
        System.out.println(sumStrings(example61, example62));
    }
}
