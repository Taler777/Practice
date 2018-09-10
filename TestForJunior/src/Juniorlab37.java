/*
Convert string to camel case

Напишите функцию так, чтобы она преобразовывала строку в которой слова разделены помощью тире / подчеркивания в строку,
которая записана по правилам camelCase.

Например:
Вход	Выход
toCamelCase("the-stealth-warrior")	"theStealthWarrior"
toCamelCase("The_Stealth_Warrior")	"TheStealthWarrior"
 */


public class Juniorlab37 {

    public static String toCamelCase(String str){
        String [] tempString = str.split("[-_]") ;
        for (int i = 1; i < tempString.length; i++) {
            String firstChar = tempString[i].substring(0,1);
            firstChar=firstChar.toUpperCase();

            tempString[i] = firstChar+ tempString[i].substring(1, tempString[i].length()) ;
        }
        str = new String();
        for (int i = 0; i < tempString.length; i++) {
            str+=tempString[i];
        }
        return str;
    }

    public static void main(String[] args) {
        String example01 = "";                      // ""
        String example11 = "the_stealth_warrior";   // "theStealthWarrior"
        String example21 = "The_stealth_warrior";   // "TheStealthWarrior"
        String example31 = "The-Stealth-Warrior";   // "TheStealthWarrior"
        String example41 = "the-Stealth-Warrior";   // "theStealthWarrior"
        String example51 = "A-B-C";                 // "ABC"
        String example61 = "I-am-a-programmer";     // "IAmAProgrammer"
        String example71 = "i-am-a-programmer";     // "iAmAProgrammer"

        System.out.println(toCamelCase(example01));
        System.out.println(toCamelCase(example11));
        System.out.println(toCamelCase(example21));
        System.out.println(toCamelCase(example31));
        System.out.println(toCamelCase(example41));
        System.out.println(toCamelCase(example51));
        System.out.println(toCamelCase(example61));
        System.out.println(toCamelCase(example71));
    }
}
