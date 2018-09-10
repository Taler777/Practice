/*
Find the unknown digit

На вход в функцию подается строка с математическим выражением.
Выражение может содержать только следующий операторы: сложение ( + ), вычитание ( - ) и умножение ( * ).
Числа состоят из цифр от 0 до 9. В каждом выражении есть символ ( ? ), который означает неизвестную цифру.
Ваша задача написать функцию, которая вернет цифру, скрывающуюся под вопросительным знаком.
Если таких цифр может быть несколько, то верните наименьшую из возможных.
Если ни одна цифра не подходит, то верните -1.
 */


public class Juniorlab36 {

    public static int solveExpression(String exp){
        exp.trim();



        return 0;
    }

    public static void main(String[] args) {
        String example01 = "?79097-355488=323509";
        String example11 = " 1+1=?";
        String example21 = "123*45?=5?088";
        String example31 = "-5?*-1=5?";
        String example41 = "19--45=5?";
        String example51 = "??*??=302?";
        String example61 = "?*11=??";
        String example71 = "??*1=??";
        String example81 = "?38???+595???=833444";
        String example91 = "-7715?5--484?00=-28?9?5";
        String example101 = "??605*-63=-73???5";
        String example111 = "?09*8?0=4326?0";

        System.out.println(solveExpression(example01)); // -1
        System.out.println(solveExpression(example11)); // 2
        System.out.println(solveExpression(example21)); // 6
        System.out.println(solveExpression(example31)); // 0
        System.out.println(solveExpression(example41)); // -1
        System.out.println(solveExpression(example51)); // 5
        System.out.println(solveExpression(example61)); // 2
        System.out.println(solveExpression(example71)); // 2
        System.out.println(solveExpression(example81)); // 2
        System.out.println(solveExpression(example91)); // 6
        System.out.println(solveExpression(example101)); // 1
        System.out.println(solveExpression(example111)); // 5
    }
}
