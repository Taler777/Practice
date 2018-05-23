import java.util.HashMap;

/*
Roman Numerals Encoder

Напишите функцию, которая переводит число, записанное арабскими цифрами в число,
записанное римскими цифрами.
В качестве входного параметра передается положительное целое число.
Возвращать функция должна строку с римским числом.

Вход / Выход
1000   -   "M"
1990   -   "MСMXC"
1666   -   "MDCLXVI"
 */
public class Juniorlab32 {
    public static String solution(int number) {
        String result = new String();
        final String romanNumerals[] = {"ZERO)))", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        final String romanNumerals10[] = {"ZERO)))", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        final String romanNumerals100[] = {"ZERO)))", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

        if (number / 1000 >= 1) {
            for (int i = 0; i < number / 1000; i++) {
                result += "M";
            }
        }
        number = number - number / 1000 * 1000;

        if (number / 100 >= 1) {
            result += romanNumerals100[number / 100];
        }
        number = number - number / 100 * 100;

        int tail = number % 10;
        if (number / 10 >= 1) {
            result += romanNumerals10[number / 10];
        }

        if (tail >0) {
            result += romanNumerals[tail];
        }
        return result;
    }

    public static void main(String[] args) {
        int example01 = 1992;
        int example11 = 1;
        int example21 = 2;
        int example31 = 3;
        int example41 = 4;
        int example51 = 5;
        int example61 = 9;
        int example71 = 10;
        int example81 = 11;
        int example91 = 19;
        int example101 = 22;
        int example111 = 1000;
        int example121 = 1001;
        int example131 = 2007;
        int example141 = 7465;
        int example151 = 345;
        int example161 = 746;
        int example171 = 1991;
        int example181 = 8463;

        System.out.println(solution(example01)); // "MCMXCII"
        System.out.println(solution(example11)); // "I"
        System.out.println(solution(example21)); // "II"
        System.out.println(solution(example31)); // "III"
        System.out.println(solution(example41)); // "IV"
        System.out.println(solution(example51)); // "V"
        System.out.println(solution(example61)); // "IX"
        System.out.println(solution(example71)); // "X"
        System.out.println(solution(example81)); // "XI"
        System.out.println(solution(example91)); // "XIX"
        System.out.println(solution(example101)); // "XXII"
        System.out.println(solution(example111)); // "M"
        System.out.println(solution(example121)); // "MI"
        System.out.println(solution(example131)); // "MMVII"
        System.out.println(solution(example141)); // "MMMMMMMCDLXV"
        System.out.println(solution(example151)); // "CCCXLV"
        System.out.println(solution(example161)); // "DCCXLVI"
        System.out.println(solution(example171)); // "MCMXCI"
        System.out.println(solution(example181)); // MMMMMMMMCDLXIII
    }
}
