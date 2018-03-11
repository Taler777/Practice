/*
IP Validation

Напишите алгоритм, который будет проверять, являются ли IPv4 адреса валидными.
IP-адреса валидны, если они состоят из 4 октетов со значениями между 0..255 (включительно)

Входной аргумент является строкой с IP адресом.

Вход / Выход

1.2.3.4   -   true

1.2.3   -   false

123.456.78.90   -   false

 */

public class Juniorlab8 {

    public static boolean isValidIP(String str) {
        String[] numbers = str.split("\\."); // разбираю строку с ip-адресом на части
        if (numbers.length != 4) return false; // проверка на 4 секции
        for (int i = 0; i < numbers.length; i++) {
            int part = -1;
            try {
                part = Integer.parseInt(numbers[i]);
            } catch (NumberFormatException e) {
                return false;
            }
            if (part > 255 || part < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String example01 = " 1.2.3.4";
        String example11 = "123.456.789.0";
        String example21 = "abc.def.ghi.jkl";
        String example31 = "12.34.56";
        String example41 = "123,45,67,89";
        String example51 = "53.58.97.93";
        String example61 = "28.84.197.169";
        String example71 = "255.255.255.255";

        System.out.println(isValidIP(example01));
        System.out.println(isValidIP(example11));
        System.out.println(isValidIP(example21));
        System.out.println(isValidIP(example31));
        System.out.println(isValidIP(example41));
        System.out.println(isValidIP(example51));
        System.out.println(isValidIP(example61));
        System.out.println(isValidIP(example71));
    }
}
