/*
Airport Arrivals/Departures - #1

Представьте, что вы находитесь в аэропорту и залипаете на доску прилета/вылета.
Вы замечаете, что каждый символ управляется с помощью ротора, а порядок символов на каждом роторе следующий:
*/
// ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789
/*
        Немного подумав, вы понимаете, что дисплей работает по следующим правилам:

        Начиная с левого края (от текущего символа до конца линии) все значения меняются,
        пока символ левого ротора не будет правильным.
        Затем механизм переходит на один ротор вправо.
        Повторяет шаг первый. И так до тех пор, пока вся строка не будет обновлена.
        Вся процедура повторяется сверху вниз, пока все табло не будет обновлено.
        функция flapDisplay принимает два аргумента: массив слов и массив смещений.

        Ваша задача написать метод, который вернет массив со строкой,
        полученной после смещений символов на указанные значения.

        Например:
        Рассмотрим дисплей, на котором отображается всего одна линия, состоящая из трех роторов.
        Изначально на нем отображается слово CAT

        Шаг 1 (Текущее положение - 1)

        Смещение на 1
        Линия стала равна DBU
        Шаг 2 (Текущее положение - 2)

        Смещение на 13
        Линия стала равна DO)
        Шаг 3 (Текущее положение - 3)

        Смещение на 27
        Линия стала равна DOG

    *** Мои комментарии
    В задаче передается не массив строк, а строка,
    поэтому решение сделано чтобы пройти тест на сайте

 */

import java.util.Arrays;

public class Juniorlab17 {
    public static String[] flapDisplay(String[] lines, int[][] rotors) {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";
        char[] linesAsCharArray = lines[0].toCharArray();
        int startPlace;
        int finishPlace;
        for (int j = 0; j < lines[0].length(); j++) {
            for (int i = j; i < lines[0].length(); i++) {
                char letter = lines[0].charAt(i); // беру символ из строки табло
                char newLetter;
                startPlace = symbols.indexOf(letter); // нахожу его позицию
                finishPlace = startPlace + rotors[0][j]; // нахожу конечную позицию
                finishPlace = finishPlace % 54; // учитываю что зададут неадекватное количество вращений символа на роторе
                int condition = symbols.length() - finishPlace;
                newLetter = symbols.charAt(finishPlace);
                linesAsCharArray[i] = newLetter;
            }
            lines[0] = new String(linesAsCharArray);
        }
//        System.out.println(linesAsCharArray);
//        System.out.println("-------");
        return lines;
    }

    public static void main(String[] args) {
        String[] example01 = {"IN SPACE NOBODY...  "};
        int[][] example02 = {{48, 47, 0, 21, 38, 120, 48, 15, 41, 11, 43, 19, 47, 3, 17, 2, 41, 50, 23, 16}};
        String[] example11 = {"CAT"};
        int[][] example12 = {{1, 13, 27}};
        String[] example21 = {"HELLO "};
        int[][] example22 = {{15, 49, 50, 48, 43, 13}};
        String[] example31 = {"CODE"};
        int[][] example32 = {{20, 20, 28, 0}};
        String[] example41 = {"NOTHING MOVED"};
        int[][] example42 = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        String[] example51 = {"EFGH"};
        int[][] example52 = {{53, 53, 53, 53}};

        System.out.println(Arrays.toString(flapDisplay(example01, example02)));
        System.out.println(Arrays.toString(flapDisplay(example11, example12)));
        System.out.println(Arrays.toString(flapDisplay(example21, example22)));
        System.out.println(Arrays.toString(flapDisplay(example31, example32)));
        System.out.println(Arrays.toString(flapDisplay(example41, example42)));
        System.out.println(Arrays.toString(flapDisplay(example51, example52)));
    }
}
