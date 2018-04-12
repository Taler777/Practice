/*
Best travel

Джон и Мери хотят посетить несколько городов A, B, C...
Мери на листке бумаги перечисляет расстояния между этими городами.
ls = [50, 55, 57, 58, 60].
Но проблема в том, что Джону надоело водить машину и он сказал Мери,
что поедет не больше t = 174 километров и максимум они посетят 3 города.

Какие расстояния, а следовательно, какие города они выберут, чтобы сумма расстояний была максимально возможной?

Например, у них есть списки из трех городов с расстояниями между ними:
[50,55,57],[50,55,58],[50,55,60],[50,57,58],[50,57,60],[50,58,60],[55,57,58],[55,57,60],[55,58,60],[57,58,60].

Суммы расстояний между этими городами составляют: 162, 163, 165, 165, 167, 168, 170, 172, 173, 175.

Так как Джон категорически против ехать больше 174 километров, то нужное нам расстояние составляет 173 километра,
а значит правильный ответ будет [55, 58, 60].

Функция chooseBestSum принимает три параметра: t - максимальная дистанция, k - число городов,
которое надо посетить и ls - массив дистанций между городами.
Функция возвращает максимальное расстояние, если такое существует, иначе null

 */

import java.util.TreeSet;

public class Juniorlab28 {

    public static Integer chooseBestSum(int t, int k, int[] ls) {
        if (k>ls.length) return null;
        TreeSet<Integer> treeSet = new TreeSet<>();
        int sum =0;
        int  last;
        int arr[] = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = i;
        }
        do {
            for (int i = 0; i < k; i++) {
                sum+=ls[arr[i]];
            }
            treeSet.add(sum);
            sum=0;
            for (last = k - 1; last >= 0 && arr[last] >= ls.length - k + last; last--) ;
            if (last >= 0) {
                arr[last]++;
                for (int i = last + 1; i < k; i++) {
                    arr[i] = arr[i - 1] + 1;
                }
            } else {
                break;
            }
        }
        while (true);
        return treeSet.floor(t);
    }

    public static void main(String[] args) {

        int example01 = 163;
        int example02 = 3;
        int[] example03 = {50, 55, 56, 57, 58};
        int example11 = 331;
        int example12 = 2;
        int[] example13 = {1000, 640, 1230, 2333, 1440, 500, 1320, 1230, 340, 890, 732, 1346};
        int example21 = 100;
        int example22 = 2;
        int[] example23 = {100, 76, 56, 44, 89, 73, 68, 56, 64, 123, 2333, 144, 50, 132, 123, 34, 89};
        int example31 = 700;
        int example32 = 6;
        int[] example33 = {91, 74, 73, 85, 73, 81, 87};
        int example41 = 331;
        int example42 = 4;
        int[] example43 = {91, 74, 73, 85, 73, 81, 87};
        int example51 = 331;
        int example52 = 2;
        int[] example53 = {91, 74, 73, 85, 73, 81, 87};
        int example61 = 230;
        int example62 = 3;
        int[] example63 = {91, 74, 73, 85, 73, 81, 87};
        int example71 = 163;
        int example72 = 3;
        int[] example73 = {50};

        System.out.println(chooseBestSum(example01, example02, example03)); // 163
        System.out.println(chooseBestSum(example11, example12, example13)); // null
        System.out.println(chooseBestSum(example21, example22, example23)); // 100
        System.out.println(chooseBestSum(example31, example32, example33)); // 491
        System.out.println(chooseBestSum(example41, example42, example43)); // 331
        System.out.println(chooseBestSum(example51, example52, example53)); // 178
        System.out.println(chooseBestSum(example61, example62, example63)); // 228
        System.out.println(chooseBestSum(example71, example72, example73)); // null
    }

}
