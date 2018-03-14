/*
Who likes it?

Вы, вероятно, знаете, как в вконтакте устроена система лайков картинок,
постов и других вещей. Вам нужно организовать текст, который будет отображаться с таким элементом.

Функция принимает массив, который содержит имена людей, лайкнувших что-либо.
Она должна возвращать сгенерированную строку, как в примерах ниже.
Для 4 и более людей отображается только первые 2 имени, остальные отображаются цифрой лайкнувших людей, за исключением первых двух.

Вход / Выход

[]   -   "no one likes this"
["Peter"]   -   "Peter likes this"
["Jacob", "Alex"]   -   "Jacob and Alex like this"
["Max", "John", "Mark"]   -    "Max, John and Mark like this"
["Alex", "Jacob", "Mark", "Max"]   -   "Alex, Jacob and 2 others like this"

 */

public class Juniorlab16 {

    public static String likes(String[] names) {
        String noOneLike = "no one likes this";
        String oneLike = "likes this";
        String twoOrThreeLikes = "like this";
        String fourAndMoreLikes = "others like this";
        String result = new String();
        if (names.length == 0) {
            result = noOneLike;
        } else if (names.length == 1) {
            result = names[0] + " " + oneLike;
        } else if (names.length == 2) {
            result = names[0] + " and " + names[1] + " " + twoOrThreeLikes;
        } else if (names.length == 3) {
            result = names[0] + ", " + names[1] + " and " + names[2] + " " + twoOrThreeLikes;
        } else {
            result = names[0] + ", " + names[1] + " and " + (names.length - 2) + " " + fourAndMoreLikes;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] example01 = {"Alex", "Jacob", "Mark", "Max"};
        String[] example11 = {};
        String[] example21 = {"Peter"};
        String[] example31 = {"Jacob", "Alex"};
        String[] example41 = {"Max", "John", "Mark"};

        System.out.println(likes(example01));
        System.out.println(likes(example11));
        System.out.println(likes(example21));
        System.out.println(likes(example31));
        System.out.println(likes(example41));
    }
}
