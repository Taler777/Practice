public class Palindrome {
//    Реализуйте метод, проверяющий, является ли заданная строка палиндромом.
//    Палиндромом называется строка, которая читается одинаково слева направо и справа налево (в том числе пустая).
//    При определении "палиндромности" строки должны учитываться только буквы и цифры.
//    А пробелы, знаки препинания, а также регистр символов должны игнорироваться.
//    Гарантируется, что в метод попадают только строки, состоящие из символов ASCII (цифры, латинские буквы, знаки препинания).

    public static void main(String[] args) {
        isPalindrome("'I' am 2 ma 'I'");
        //isPalindrome("1255321");
    }

    public static void isPalindrome(String text) {
        // удаляю из строки все символы кроме (^) указанных в регулярном выражении ([^a-zA-Z0-9])
        text = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder sb = new StringBuilder(text);
        sb.reverse();
        String text2 = new String(sb);
        System.out.println(text);
        System.out.println(text2);
        System.out.println(text.equals(text2));
    }
}
