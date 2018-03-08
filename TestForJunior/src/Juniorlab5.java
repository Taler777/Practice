/*
В качестве аргумента функция принимает строку.
Верните строку, модифицировав ее таким образом, что бы каждая заглавная буква стала строчной,
а каждая строчная - заглавной

Вход / Выход

hello world   -   HELLO WORLD
HeLLo WoRLD   -   hEllO wOrld
12345   -   12345
1a2b3c4d5e   -   1A2B3C4D5E

 */

public class Juniorlab5 {
    public static String alternatingCase(String str) {
        char[] chars = str.toCharArray();
        String result = new String();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isAlphabetic(chars[i])) {
                if (Character.isLowerCase(chars[i])) {
                    chars[i] = Character.toUpperCase(chars[i]);
                } else {
                    chars[i] = Character.toLowerCase(chars[i]);
                }
            }
        }

        for (int i = 0; i < chars.length; i++) {
            result += chars[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String example01 = "Hello World";
        String example11 = "hello world";
        String example21 = "HeLLo WoRLD";
        String example31 = "HELLO WORLD";
        String example41 = "hello WORLD";
        String example51 = "12345";
        String example61 = "1a2b3c4d5e";

        System.out.println(alternatingCase(example01));
        System.out.println(alternatingCase(example11));
        System.out.println(alternatingCase(example21));
        System.out.println(alternatingCase(example31));
        System.out.println(alternatingCase(example41));
        System.out.println(alternatingCase(example51));
        System.out.println(alternatingCase(example61));
    }
}
