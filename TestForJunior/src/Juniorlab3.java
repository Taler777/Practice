/*
Вы должны написать функцию sentencify, которая получает в качестве аргумента массив слов,
а возвращает корректное предложение, составленное из этих слов

Ваша функция должна:

Предложение должно начинаться с заглавной буквы.
В конце предложения должна стаять точка.
Между словами должен быть пробел.
Не выполняйте никаких других действий над словами.

Вход - выход
["i", "am", "an", "AI"]   -  "I am an AI."
["FIELDS","of","CORN","are","to","be","sown"]   -   "FIELDS of CORN are to be sown."
["i'm","afraid","I","can't","let","you","do","that"]   -  "I'm afraid I can't let you do that."

 */


public class Juniorlab3 {


    public static String sentencify(String[] words) {
        char[] charArray = words[0].toCharArray();
        if(Character.isAlphabetic(charArray[0])) charArray[0]=Character.toUpperCase(charArray[0]);
        String firstWord = new String();
        for (int i = 0; i < charArray.length; i++) {
            firstWord+=charArray[i];
        }
words[0] = firstWord.substring(0,firstWord.length());
        String result = new String();
        for (String word : words) {
            result = result + word + " ";
        }
        result = result.trim() + ".";
        return result;
    }

    public static void main(String[] args) {
        String[] example01 = {"yes"};
        String[] example11 = {"i", "am", "an", "AI"};
        String[] example21 = {"Eqsjljvg", "qzmvvnsftq", "vfvtcztccd", "qoxmkdlj", "trbnkd", "runo", "usxjjzc", "ojwwic", "lqwegnro", "lhatj"};
        String[] example31 = {"Cnqumyzpl", "nagmknl", "amjrarohf", "tledyoxc", "czluzczscl", "gdhkkj", "muqhareo", "zwxypbx", "ntmshksfe", "qqebzsouj"};
        String[] example41 = {"let", "there", "be", "light"};
        String[] example51 = {"i'm", "afraid", "I", "can't", "let", "you", "do", "that"};
        String[] example61 = {"FIELDS", "of", "CORN", "are", "to", "be", "sown"};

        System.out.println(sentencify(example01));
        System.out.println(sentencify(example11));
        System.out.println(sentencify(example21));
        System.out.println(sentencify(example31));
        System.out.println(sentencify(example41));
        System.out.println(sentencify(example51));
        System.out.println(sentencify(example61));
    }
}
