/*
Credit card

Выясните, какой платежной системе принадлежит карта по ее номеру.
Если система неизвестна, то вернуть Unknow.

AMEX: номер начинает с 34 или 37 и его длина 15 цифр
Discover: номер начинает с 6011 и его длина 16 цифр
Mastercard: номер начинает с 51, 52, 53, 54 или 55 и его длина 16 цифр
VISA: номер начинает с 4 и его длина 13 или 16 цифр
Например:
Вход / Выход
4111111111111111   -   "VISA"
378282246310005   -   "AMEX"
6011111111111117   -   "Discover"
5105105105105100   -   "Mastercard"
9111111111111111   -   "Unknown"
 */

public class Juniorlab34 {

    public static String getIssuer(long number) {
        String result = new String();
        String cardNumber = "" + number;
        int lengthCardNumber = cardNumber.length();
        if ((lengthCardNumber == 13 || lengthCardNumber == 16) && cardNumber.charAt(0) == '4') {
            result = "VISA";
        } else if (lengthCardNumber == 16 && cardNumber.startsWith("6011")) {
            result = "Discover";
        } else if (lengthCardNumber == 15 &&
                (cardNumber.startsWith("34") || cardNumber.startsWith("37"))) {
            result = "AMEX";
        } else if (lengthCardNumber == 16 &&
                (cardNumber.startsWith("51")
                        || cardNumber.startsWith("52")
                        || cardNumber.startsWith("53")
                        || cardNumber.startsWith("54")
                        || cardNumber.startsWith("55"))) {
            result = "Mastercard";
        } else {
            result = "Unknown";
        }
        return result;
    }

    public static void main(String[] args) {
        long example01 = 9111111111111112l;
        long example11 = 4111111111111111l;
        long example21 = 4111111111111l;
        long example31 = 4012888888881881l;
        long example41 = 378282246310005l;
        long example51 = 348282246310005l;
        long example61 = 6011111111111117l;
        long example71 = 5105105105105100l;
        long example81 = 5205105105105106l;
        long example91 = 5605105105105106l;

        System.out.println(getIssuer(example01)); // "Unknown"
        System.out.println(getIssuer(example11)); // "VISA"
        System.out.println(getIssuer(example21)); // "VISA"
        System.out.println(getIssuer(example31)); // "VISA"
        System.out.println(getIssuer(example41)); // "AMEX"
        System.out.println(getIssuer(example51)); // "AMEX"
        System.out.println(getIssuer(example61)); // "Discover"
        System.out.println(getIssuer(example71)); // "Mastercard"
        System.out.println(getIssuer(example81)); // "Mastercard"
        System.out.println(getIssuer(example91)); // "Unknown"
    }
}
