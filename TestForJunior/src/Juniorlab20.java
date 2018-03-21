/*
Tortoise racing

Две черепахи A и B участвуют в гонке. A начинает бежать со скоростью 720 футов в час.
Черепаха B моложе и бегает быстрее, поэтому она не торопясь доедает свой завтрак.

Когда она начинает гонку, черепаха A уже убежала на 70 футов,
но у черепахи B скорость 850 футов в час. Как быстро B догонит A?

Или, говоря более техническим языком: даны две скорости v1 (Скорость черепахи A, v1 > 0) и v2 (Скорость черепахи B, v2 > 0)
и расстояние между ними g. Через сколько они встретятся?

Результат должен быть массивом [часы, минуты, секунды], который содержит часы минуты и секунды.

Если v1 >= v2 тогда нужно вернуть null, None в зависимости от языка.


 */

import java.util.Arrays;

public class Juniorlab20 {

    public static int[] race(int v1, int v2, int g) {
        int[] result;
        if (v1 > v2) {
            return null;
        } else {
            float time = (float)g / (float)(v2 - v1);
            int hour = (int)(time);
            int minute = (int)((time - (float) hour ) *60);
            int second = (int)(  ( (time - (float) hour - (float)minute/60)*60*60));
            result = new int[]{hour, minute, second};
        }
        return result;
    }

    public static void main(String[] args) {
        int example01 = 185;
        int example02 = 661;
        int example03 = 131;
        int example11 = 720;
        int example12 = 850;
        int example13 = 70;
        int example21 = 80;
        int example22 = 91;
        int example23 = 37;
        int example31 = 80;
        int example32 = 100;
        int example33 = 40;
        int example41 = 720;
        int example42 = 850;
        int example43 = 370;
        int example51 = 120;
        int example52 = 850;
        int example53 = 37;
        int example61 = 820;
        int example62 = 850;
        int example63 = 550;
        int example71 = 617;
        int example72 = 815;
        int example73 = 108;
        int example81 = 665;
        int example82 = 695;
        int example83 = 95;

        System.out.println(Arrays.toString(race(example01, example02, example03))); // {0, 16, 30}
        System.out.println(Arrays.toString(race(example11, example12, example13))); // {0, 32, 18}
        System.out.println(Arrays.toString(race(example21, example22, example23))); // {3, 21, 49}
        System.out.println(Arrays.toString(race(example31, example32, example33))); // {2, 0, 0}
        System.out.println(Arrays.toString(race(example41, example42, example43))); // {2, 50, 46}
        System.out.println(Arrays.toString(race(example51, example52, example53))); // {0, 3, 2}
        System.out.println(Arrays.toString(race(example61, example62, example63))); // {18, 20, 0}
        System.out.println(Arrays.toString(race(example71, example72, example73))); // {0, 32, 43}
        System.out.println(Arrays.toString(race(example81, example82, example83))); // {3, 10, 0}
    }
}
