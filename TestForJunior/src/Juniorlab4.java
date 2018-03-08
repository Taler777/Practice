/*
Переместите первую букву в каждом слове в конец и добавьте 'ay'.

Вход / Выход
Pig latin is cool   - igPay atinlay siay oolcay
Hello world !   -    elloHay orldWay !

 */

public class Juniorlab4 {

    public static String pigIt(String str) {
        String[] string = str.split(" "); //делаю массив слов из строки
        String result = new String();
        for (int i = 0; i < string.length; i++) {
            char firstLetter = string[i].charAt(0); // беру первый символ
            if (Character.isAlphabetic(firstLetter)) { // если это буква алфавита, то
                String stringWithoutFirstLetter = string[i].substring(1, string[i].length()); // удаляю из слова первую букву
                string[i] = stringWithoutFirstLetter + firstLetter + "ay"; // перемещаю первую букву в слове в конец и добавляю 'ay'
            }
        }
        for (String word : string) {
            result = result + word + " ";
        }
        result = result.trim();
        return result;
    }

    public static void main(String[] args) {
        String example01 = "This is my string";
        String example11 = "Pig latin is cool";
        String example21 = "Hello world !";

        pigIt(example01);
        pigIt(example11);
        pigIt(example21);
    }
}
