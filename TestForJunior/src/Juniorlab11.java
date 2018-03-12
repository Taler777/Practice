/*
Найдите наибольший общий делитель двух положительных целых чисел.
Числа могу быть очень большими, поэтому подходите к решению с умом.

Входящие аргументы x и y всегда больше или равны 1,
поэтому наибольший общий делитель всегда будет целым числом,
которое больше или равно 1.

 */

public class Juniorlab11 {

    public static int mygcd(int x, int y) {
        int result = 0;
        int divider;
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        if (max % min == 0) {
            result = min;
        } else {
            divider = min / 2;
            for (int i = divider; i > 0; i--) {
                if (max % i == 0 && min % i == 0) {
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int example01 = 49771202;
        int example02 = 22754440;
        int example11 = 30;
        int example12 = 12;
        int example21 = 8;
        int example22 = 9;
        int example31 = 1;
        int example32 = 1;
        int example41 = 1;
        int example42 = 3;
        int example51 = 60;
        int example52 = 12;
        int example61 = 2672;
        int example62 = 5678;
        int example71 = 10927782;
        int example72 = 6902514;
        int example81 = 1590771464;
        int example82 = 1590771620;
        int example91 = 9109871;
        int example92 = 11712241;
        int example101 = 8500532;
        int example102 = 9377930;
        int example111 = 14845952;
        int example112 = 22223520;
        int example121 = 26689852;
        int example122 = 19664768;
        int example131 = 84206;
        int example132 = 920;

        System.out.println(mygcd(example01, example02));
        System.out.println(mygcd(example11, example12));
        System.out.println(mygcd(example21, example22));
        System.out.println(mygcd(example31, example32));
        System.out.println(mygcd(example41, example42));
        System.out.println(mygcd(example51, example52));
        System.out.println(mygcd(example61, example62));
        System.out.println(mygcd(example71, example72));
        System.out.println(mygcd(example81, example82));
        System.out.println(mygcd(example91, example92));
        System.out.println(mygcd(example101, example102));
        System.out.println(mygcd(example111, example112));
        System.out.println(mygcd(example121, example122));
        System.out.println(mygcd(example131, example132));
    }
}
