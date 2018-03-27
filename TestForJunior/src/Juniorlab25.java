/*
Basic DeNico
Завершите функцию, которая принимает два параметра:

key - строка из уникальных букв и цифр
message - строка с закодированным сообщением
Ваша задача восстановить сообщение, используя ключ

Сперва создайте ключ на основе предоставленного ключа путем сортировки ключа в алфавитном порядке и
устаноквки позиции элементов в отсортированном ключе.

Например, для ключа crazy мы получим 23154, потому что acryz (отсортированный ключ).
Расшифруем наше сообщение cseerntiofarmit on используя ключ crazy

1 2 3 4 5
---------
c s e e r
n t i o f
a r m i t
  o n
После использования ключа:

2 3 1 5 4
---------
s e c r e
t i n f o
r m a t i
o n
Заметки:
Сообщение всегда длиннее ключа.
Не забудьте удалить пробелы в конце предложения.

 */


import java.util.Arrays;

public class Juniorlab25 {

    public static String deNico(String key, String message) {
        int keyLength = key.length();
        int messageLength = message.length();
        int matrixRows = messageLength / keyLength;
        if (messageLength % keyLength != 0) {
            matrixRows++;
        }
        char[][] matrix = new char[matrixRows][keyLength];
        // заполняю матрицу из message
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < keyLength; j++) {
                if (keyLength * i + j < messageLength) {
                    matrix[i][j] = message.charAt(keyLength * i + j);
                } else {
                    break;
                }
            }
        }
        // сортировка ключа
        char[] sortKey = key.toCharArray();
        Arrays.sort(sortKey);
        String sortKeyAsString = String.valueOf(sortKey);
        char newMatrix[][] = new char[matrixRows][keyLength];
        // переношу в новую матрицу в нужном порядке
        for (int i = 0; i < keyLength; i++) {
            char symbol = key.charAt(i);
            int newPosition = sortKeyAsString.indexOf(symbol);
            for (int j = 0; j < matrixRows; j++) {
                newMatrix[j][i] = matrix[j][newPosition];
            }
        }
        String result = new String();
        // формирую result
        for (int i = 0; i < matrixRows - 1; i++) {
            result += new String(newMatrix[i]);
        }
        // удаляю пробелы в последнем куске
        result += (new String(newMatrix[matrixRows - 1])).trim();
        return result;
    }

    public static void main(String[] args) {
        String example01 = "6gr5";
        String example02 = "e pfjgut 1uv";
        String example11 = "crazy";
        String example12 = "cseerntiofarmit on  ";
        String example21 = "crazy";
        String example22 = "cseerntiofarmit on";
        String example31 = "abc";
        String example32 = "abcd";
        String example41 = "ba";
        String example42 = "2143658709";
        String example51 = "a";
        String example52 = "message";
        String example61 = "key";
        String example62 = "eky";
        String example71 = "xemd";
        String example72 = "n69m73qk62uf6wrfijayycbyxn6dr7aalwna swc";

        System.out.println(deNico(example01, example02)); // " pfegutj1uv"
        System.out.println(deNico(example11, example12)); // "secretinformation"
        System.out.println(deNico(example21, example22)); // "secretinformation"
        System.out.println(deNico(example31, example32)); // "abcd"
        System.out.println(deNico(example41, example42)); // "1234567890"
        System.out.println(deNico(example51, example52)); // "message"
        System.out.println(deNico(example61, example62)); // "key"
        System.out.println(deNico(example71, example72)); // "m69nk3q7f2u6fwr6yjaiycbydn6xa7arawnlcsw"
    }
}