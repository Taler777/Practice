/*
Good vs Evil

В средиземье близится война. Грядет много битв сил света со тьмой.
Как с одной так и с другой стороны расы решают объединиться, чтобы общими усилиями одолеть врага.
Каждая раса обладает своими силами, которые оцениваются баллами. На стороне добра будут сражаться:

Хоббиты: 1
Люди: 2
Эльфы: 3
Гномы: 3
Орлы: 4
Волшебники: 10
На темной стороне сражаются:

Орки: 1
Люди: 2
Варги: 2
Гоблины: 2
Урук-хаи: 3
Тролли: 5
Волшебники: 10
Ваша задача определить, кто же победит в битве.

Функция принимает два аргумента, которые являются строками.
В каждой строке через пробел перечислено количество существ,
которые будут сражаться за расу (порядок такой же, как в перечисленных выше списках).

Функция должна возвращать "Battle Result: Good triumphs over Evil" если побеждают хорошие,
"Battle Result: Evil eradicates all trace of Good" если побеждает зло и
"Battle Result: No victor on this battle field" если ничья.

 */

public class Juniorlab22 {

    public static String goodVsEvil(String good, String evil) {
        final String RESULT_1 = "Battle Result: Good triumphs over Evil";
        final String RESULT_2 = "Battle Result: Evil eradicates all trace of Good";
        final String RESULT_3 = "Battle Result: No victor on this battle field";
        int[] pointGood = {1, 2, 3, 3, 4, 10};
        int[] pointEvil = {1, 2, 2, 2, 3, 5, 10};
        String result;
        String goodArray[] = good.split(" ");
        String evilArray[] = evil.split(" ");
        int goodPower = 0;
        int evilPower = 0;
        for (int i = 0; i < goodArray.length; i++) {
            goodPower += Integer.parseInt(goodArray[i]) * pointGood[i];
        }
        for (int i = 0; i < goodArray.length; i++) {
            evilPower += Integer.parseInt(evilArray[i]) * pointEvil[i];
        }
        if (goodPower > evilPower) {
            result = RESULT_1;
        } else if (goodPower < evilPower) {
            result = RESULT_2;
        } else {
            result = RESULT_3;
        }
        return result;
    }

    public static void main(String[] args) {
        String example01 = "0 0 0 1 0 0";
        String example02 = "0 0 0 0 1 0 0";
        String example11 = "707 423 584 293 572 62";
        String example12 = "136 864 0 626 15 152 121";
        String example21 = "132 196 432 622 929 373";
        String example22 = "761 683 48 801 805 463 176";
        String example31 = "830 55 258 226 261 227";
        String example32 = "831 876 577 745 781 6 438";
        String example41 = "869 260 246 189 401 378";
        String example42 = "41 826 818 746 393 705 95";
        String example51 = "0 1 0 0 0 0";
        String example52 = "0 0 0 1 0 0 0";

        System.out.println(goodVsEvil(example01, example02)); // "Battle Result: No victor on this battle field"
        System.out.println(goodVsEvil(example11, example12)); // "Battle Result: Good triumphs over Evil"
        System.out.println(goodVsEvil(example21, example22)); // "Battle Result: Good triumphs over Evil"
        System.out.println(goodVsEvil(example31, example32)); // "Battle Result: Evil eradicates all trace of Good"
        System.out.println(goodVsEvil(example41, example42)); // "Battle Result: Evil eradicates all trace of Good"
        System.out.println(goodVsEvil(example51, example52)); // "Battle Result: No victor on this battle field"
    }
}
