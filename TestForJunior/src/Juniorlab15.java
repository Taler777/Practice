/*
RGB To Hex Conversion

Допишите функцию rgb(). В качестве аргументов она принимает десятичные значения RGB.
Функция должна вернуть значение цвета в шестнадцатеричном формате.
Допустимые значения RGB в десятичном формате равны 0-255.
Если числа выходят за указанный диапазон, то нужно округлить их до ближайшего возможного числа.
Ниже приведены примеры.

Вход / Выход

rgb(255, 255, 255)   -   FFFFFF
rgb(255, 255, 300)   -   FFFFFF
rgb(0, 0, 0)         -   000000
rgb(148, 0, 211)     -   9400D3
 */

public class Juniorlab15 {

    public static String rgb(int r, int g, int b) {
        String result = new String();
        int[] array = new int[]{r, g, b};
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 255) {
                array[i] = 255;
            } else if (array[i] < 0) {
                array[i] = 0;
            }
            if (array[i] == 0) {
                result += "00";
            } else {
                result += ((Integer) array[i]).toHexString(array[i]).toUpperCase();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int example01 = 173;
        int example02 = 255;
        int example03 = 47;
        int example11 = 255;
        int example12 = 255;
        int example13 = 255;
        int example21 = 255;
        int example22 = 255;
        int example23 = 300;
        int example31 = 0;
        int example32 = 0;
        int example33 = 0;
        int example41 = 148;
        int example42 = 0;
        int example43 = 211;
        int example51 = 0;
        int example52 = 0;
        int example53 = -20;

        System.out.println(rgb(example01, example02, example03));
        System.out.println(rgb(example11, example12, example13));
        System.out.println(rgb(example21, example22, example23));
        System.out.println(rgb(example31, example32, example33));
        System.out.println(rgb(example41, example42, example43));
        System.out.println(rgb(example51, example52, example53));
    }
}
