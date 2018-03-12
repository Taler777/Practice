/*
На вход в качестве аргументов передаются два массива a1 и a2. Нужно вернуть массив r,
который содержит отсортированные в лексикографическом порядке строки массива a1,
которые являются подстроками строк массива a2

Вход
{"tarp", "mice", "bull"};
{"lively", "alive", "harp", "sharp", "armstrong"};
Выход
{}

Вход
{"xyz", "live", "strong"};
{"lively", "alive", "harp", "sharp", "armstrong"};
Выход
{"live", "strong"}

Вход
{"live", "strong", "arp"};
{"lively", "alive", "harp", "sharp", "armstrong"};
Выход
{"arp", "live", "strong"}

 */

import java.util.Arrays;
import java.util.TreeSet;

public class Juniorlab12 {

    public static String[] inArray(String[] array1, String[] array2) {
        String[] result;
        TreeSet<String> treeSet = new TreeSet<>();
        for (String subString : array1) {
            for (String fullString : array2) {
                if (fullString.contains(subString)) {
                    treeSet.add(subString);
                }
            }
        }
        int size = treeSet.size();
        result = new String[size];
        String element;
        for (int i = 0; i < size; i++) {
            result[i] = treeSet.pollFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        String[] example01 = {"tarp", "mice", "bull"};
        String[] example02 = {"lively", "alive", "harp", "sharp", "armstrong"};
        String[] example11 = {"xyz", "live", "strong"};
        String[] example12 = {"lively", "alive", "harp", "sharp", "armstrong"};
        String[] example21 = {"live", "strong", "arp"};
        String[] example22 = {"lively", "alive", "harp", "sharp", "armstrong"};

        System.out.println(Arrays.toString(inArray(example01, example02)));
        System.out.println(Arrays.toString(inArray(example11, example12)));
        System.out.println(Arrays.toString(inArray(example21, example22)));
    }
}
