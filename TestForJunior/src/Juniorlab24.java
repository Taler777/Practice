/*
Fibonacci, Tribonacci and friends

Нужно вычислить функцию xbonacci.
Для получения следующего числа последовательности нужно сложить предыдущие числа в количестве,
равным первоночальному размеру массива.
Количество значений в итоговой последовательности должно быть равно n.
Метод должен вернуть массив.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Juniorlab24 {
    public static long[] xbonacci(int[] signature, int n) {
        ArrayList<Long> arrayList = new ArrayList<>();
        long sum = 0;
        long[] result = new long[n];
        // если размер массива на выходе = 0
        if (n == 0) {
            return result;
            // если размер исходного массива больше n
        } else if (signature.length > n) {
            for (int i = 0; i < n; i++) {
                arrayList.add((long) signature[i]);
            }
            result = arrayList.stream().mapToLong(i -> i).toArray();
            // если размер исходного массива меньше n
        } else if (signature.length < n) {
            for (int i = 0; i < signature.length; i++) {
                arrayList.add((long) signature[i]);
                sum += signature[i];
            }
            for (int i = signature.length; i < n; i++) {
                arrayList.add(sum);
                long firstNumber = arrayList.get(arrayList.size() - 1 - signature.length);
                long lastNumber = arrayList.get(arrayList.size() - 1);
                sum = sum - firstNumber + lastNumber;
            }
            result = arrayList.stream().mapToLong(i -> i).toArray();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] example01 = {2, 13, 0, 12, 20, 4, 5, 4, 15, 9, 15, 3, 17, 9, 15, 10, 6, 12};
        int example02 = 49;
        int[] example11 = {0, 1};
        int example12 = 10;
        int[] example21 = {0, 0, 0, 0, 1};
        int example22 = 10;
        int[] example31 = {1, 1};
        int example32 = 10;
        int[] example41 = {1, 0, 0, 0, 0, 0, 1};
        int example42 = 10;
        int[] example51 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int example52 = 20;
        int[] example61 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int example62 = 9;
        int[] example71 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int example72 = 0;

        System.out.println(Arrays.toString(xbonacci(example01, example02))); // {2,13,0,12,20,4,5,4,15,9,15,3,17,9,15,10,6,12,171,340,667,1334,2656,5292,10580,21155,42306,84597,169185,338355,676707,1353397,2706785,5413555,10827100,21654194,43308376,86616581,173232822,346464977,692928620,1385854584,2771703876,5543397172,11086773189,22173504072,44346923547,88693677909,177387017463}
        System.out.println(Arrays.toString(xbonacci(example11, example12))); // {0,1,1,2,3,5,8,13,21,34}
        System.out.println(Arrays.toString(xbonacci(example21, example22))); // {0,0,0,0,1,1,2,4,8,16}
        System.out.println(Arrays.toString(xbonacci(example31, example32))); // {1,1,2,3,5,8,13,21,34,55}
        System.out.println(Arrays.toString(xbonacci(example41, example42))); // {1,0,0,0,0,0,1,2,3,6}
        System.out.println(Arrays.toString(xbonacci(example51, example52))); // {1,0,0,0,0,0,0,0,0,0,1,1,2,4,8,16,32,64,128,256}
        System.out.println(Arrays.toString(xbonacci(example61, example62))); // {1,2,3,4,5,6,7,8,9}
        System.out.println(Arrays.toString(xbonacci(example71, example72))); // {}

        //long [] hhh =new long[]{2,13,0,12,20,4,5,4,15,9,15,3,17,9,15,10,6,12,171,340,667,1334,2656,5292,10580,21155,42306,84597,169185,338355,676707,1353397,2706785,5413555,10827100,21654194,43308376,86616581,173232822,346464977,692928620,1385854584,2771703876l,5543397172l,11086773189l,22173504072l,44346923547l,88693677909l,177387017463l};
    }
}