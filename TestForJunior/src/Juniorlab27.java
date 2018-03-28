/*
Reverse polish notation calculator

Ваша задача написать ОПН калькулятор. Обратная польская нотация

Например, выражение 5 1 2 + 4 * + 3 - эквивалентно выражению 5 + ((1 + 2) * 4) - 3 в нормальной записи
и его результат будет равен 14.

Для упрощения все символы всегда разделены между собой пробелом.
Так выражение 1 2 + валидно, а 1 2+ нет.
Пустая строка должна возвращать 0.
Допустимы математические операции + - * /.
 */

import java.util.ArrayList;

public class Juniorlab27 {

    public static double calc(String expr) {
        double result = 0.0;
        String member[] = expr.split(" ");
        ArrayList<Double> arrayList = new ArrayList();
        if (!member[0].equals("")) {
            for (int i = 0; i < member.length; i++) {
                // если число со знаком слитно, то ошибка
                if (member[i].matches("[0-9][+-/*]") || member[i].matches("[0-9]{1,6}[.]{0,1}[0-9{0,6][+-/*]")) {
                    result = 0;
                    continue;
                }
                // если число целое или с десятичной частью, то продолжаем
                else if (member[i].matches("[0-9]{1,6}") || member[i].matches("[0-9]{1,6}[.]{0,1}[0-9{0,6]")) {
                    arrayList.add(Double.parseDouble(member[i]));
                    continue;
                }
                // если это знак действия, то продолжаем
                else if (member[i].matches("[+-/*]")) {
                    if (member[i].equals("+") && i > 1) {
                        arrayList.add(arrayList.get(arrayList.size() - 2) + arrayList.get(arrayList.size() - 1));
                    } else if (member[i].equals("-") && i > 1) {
                        arrayList.add(arrayList.get(arrayList.size() - 2) - arrayList.get(arrayList.size() - 1));
                    } else if (member[i].equals("*") && i > 1) {
                        arrayList.add(arrayList.get(arrayList.size() - 2) * arrayList.get(arrayList.size() - 1));
                    } else if (member[i].equals("/") && i > 1) {
                        arrayList.add(arrayList.get(arrayList.size() - 2) / arrayList.get(arrayList.size() - 1));
                    }
                    arrayList.remove(arrayList.size() - 2);
                    arrayList.remove(arrayList.size() - 2);
                }
            }
            result = arrayList.get(arrayList.size()-1);
        }
        return result;
    }

    public static void main(String[] args) {
        String example01 = "5 1 2 + 4 * + 3 -";
        String example11 = "";
        String example21 = "1 2 3";
        String example31 = "1 2 3 3.5";
        String example41 = "1 3 +";
        String example51 = "1 3 *";
        String example61 = "1 3 -";
        String example71 = "4 2 /";
        String example81 = "10000 123 +";

        System.out.println(calc(example01)); // 14
        System.out.println(calc(example11)); // 0
        System.out.println(calc(example21)); // 3
        System.out.println(calc(example31)); // 3.5
        System.out.println(calc(example41)); // 4
        System.out.println(calc(example51)); // 3
        System.out.println(calc(example61)); // -2
        System.out.println(calc(example71)); // 2
        System.out.println(calc(example81)); // 10123
    }
}
