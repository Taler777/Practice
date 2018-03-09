/*
Если взять натуральные числа, которые меньше 10 и кратны 3 или 5,
то мы получим следующие значения: 3, 5, 6, 9. Сумма этих чисел равна 23.

Напишите функцию, которая должна возвращать сумму всех чисел,
которые кратны 3 или 5 и меньше переданного в функцию числа.

Отрицательные и нецелые (рациональные, вещественные, …) числа к натуральным не относят.
 */

public class Juniorlab7 {

    public static int solution(int number) {
        int result = 0;
        if (number < 4) {
            return 0;
        } else {
            for (int i = number - 1; i > 0; i--) {
                if (i % 3 == 0 || i % 5 == 0) {
                    result += i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int example01 = 196;
        int example11 = 10;
        int example21 = 20;
        int example31 = 200;
        int example41 = -1;
        int example51 = 0;
        int example61 = 1;
        int example71 = 2;
        int example81 = 3;
        int example91 = 4;
        int example101 = 174;
        int example111 = 57;

        System.out.println(solution(example01));
        System.out.println(solution(example11));
        System.out.println(solution(example21));
        System.out.println(solution(example31));
        System.out.println(solution(example41));
        System.out.println(solution(example51));
        System.out.println(solution(example61));
        System.out.println(solution(example71));
        System.out.println(solution(example81));
        System.out.println(solution(example91));
        System.out.println(solution(example101));
        System.out.println(solution(example111));
    }
}
