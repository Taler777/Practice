import java.util.Arrays;

/*
Consonant value
Английский алфавит содержит 26 букв: a = 1, b = 2 ... z = 26.
Найдите максимальное значение, которое получается путем сложения номеров подряд идущих согласных.
Приведем пример. Слово zodiacs содержит следующие подстроки согласных: z, d, cs.
Сумма этих подстрок равна соответственно 26, 4, 22 т.к. z = 26, d = 4, cs = 3 + 19 = 22.
Максимальное значение среди этих цифр равно 26. Соответственно функция должна вернуть 26.

 */
public class Juniorlab35 {
    public static int solve(String s) {
        String values = new String();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            String letter = String.valueOf(s.charAt(i));
            if (letter.matches("[bcdfghjklmnprstvwxz]")) {
                sum += symbol - 96;
            } else if (sum > 0) {
                values += sum + " ";
                sum = 0;
            }
        }
        String[] arrayOfValues = values.trim().split(" ");
        int array[] = new int[arrayOfValues.length];
        for (int i = 0; i < arrayOfValues.length; i++) {
            array[i] = Integer.parseInt(arrayOfValues[i]);
        }
        Arrays.sort(array);
        return array[array.length - 1];
    }

    public static void main(String[] args) {
        String example01 = "mischtschenkoana";
        String example11 = "zodiac";
        String example21 = "chruschtschov";
        String example31 = "khrushchev";
        String example41 = "strength";
        String example51 = "catchphrase";
        String example61 = "twelfthstreet";

        System.out.println(solve(example01)); // 80
        System.out.println(solve(example11)); // 26
        System.out.println(solve(example21)); // 80
        System.out.println(solve(example31)); // 38
        System.out.println(solve(example41)); // 57
        System.out.println(solve(example51)); // 73
        System.out.println(solve(example61)); // 103
    }
}
