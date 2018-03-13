/*
   Valid Braces
Напишите функцию, которая принимает строку скобок.
Нужно определить, является ли валидной последовательность скобок.
Если последовательность валидна, вернуть true, иначе - false.
Все строки не пустые и будут состоять из следующих скобок: (){}[]

 */

import java.util.ArrayList;

public class Juniorlab2 {

    public static boolean validBraces(String braces) {
        boolean result = false;
        String bracesType = "[](){}";
        ArrayList<Character> line = new ArrayList<>();
        for (int i = 0; i < braces.length(); i++) {
            char currentBrace = braces.charAt(i);
            char lastBrace;
            if (currentBrace == '{' || currentBrace == '[' || currentBrace == '(') {
                line.add(currentBrace);
            } else if (currentBrace == '}' || currentBrace == ']' || currentBrace == ')') {
                if (line.size() == 0) {
                    return false;
                } else {
                    lastBrace = line.get(line.size() - 1);
                    String pair = "" + lastBrace + currentBrace;
                    if (bracesType.contains(pair)) {
                        line.remove(line.size() - 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        if (line.size() == 0) {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        String example01 = "}}]]))}])";
        String example11 = "()";
        String example21 = "[]";
        String example31 = "(){}[]";
        String example41 = "([{}])";
        String example51 = "(}";
        String example61 = "[(])";
        String example71 = "({})[({})]";
        String example81 = "(})";
        String example91 = "())({}}{()][][";

        System.out.println(validBraces(example01)); // false
        System.out.println(validBraces(example11)); // true
        System.out.println(validBraces(example21)); // true
        System.out.println(validBraces(example31)); // true
        System.out.println(validBraces(example41)); // true
        System.out.println(validBraces(example51)); // false
        System.out.println(validBraces(example61)); // false
        System.out.println(validBraces(example71)); // true
        System.out.println(validBraces(example81)); // false
        System.out.println(validBraces(example91)); // false
    }
}