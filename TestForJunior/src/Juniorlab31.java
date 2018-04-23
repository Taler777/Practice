/*
Double Cola

Шелдон, Леонард, Пенни, Раджеш и Говард стоят в очереди к автомату с газировкой за бутылочкой колы.
Первый стоит Шелдон.
Он покупает банку колы, выпивает ее и становится в конец очереди раздвоенный буквально
(в конце очереди теперь два Шелдона).
Далее в очереди стоял Леонард, который так же пьет колу и уходит раздвоенным в конец очереди.
Таким образом, если считать, что последняя выпила Пенни и она стояла в очереди третей,
то последовательность будет выглядеть так:

Раджеш, Говард, Шелдон, Шелдон, Леонард, Леонард, Пенни, Пенни

Напишите функцию, которая вернет выпившего колу n-ого человека.

Например:
Вход / Выход
whoIsNext(["Sheldon", "Leonard", "Penny", "Rajesh", "Howard"], 1)   -   "Sheldon"

whoIsNext(["Sheldon", "Leonard", "Penny", "Rajesh", "Howard"], 52)   -   "Penny"

whoIsNext(["Sheldon", "Leonard", "Penny", "Rajesh", "Howard"], 7230702951)   -   "Leonard"
 */

import java.util.ArrayList;
import java.util.Collections;

public class Juniorlab31 {
    public static String whoIsNext(String[] names, int n) {
        String result = new String();
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, names);
        if (n <= names.length) {
            result = names[n - 1];
        } else {
            for (int i = 0; i < n && arrayList.size() <= n; i++) {
                arrayList.add(arrayList.get(i));
                arrayList.add(arrayList.get(i));
            }
            result = arrayList.get(n - 1);
        }
        // вывод в консоль размера arrayList, чтобы убедиться, что не намолотил лишнего
        // System.out.println("n = " + n + "    arrayList.size()-1  = " + (arrayList.size() - 1));
        return result;
    }

    public static void main(String[] args) {
        String[] example01 = {"Daisuke Aramaki", "Motoko Kusanagi", "Batou", "Togusa", "Ishikawa", "Saito", "Pazu", "Borma", "Azuma", "Yano", "Proto"};
        int example02 = 28;
        String[] example11 = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int example12 = 1;
        String[] example21 = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int example22 = 6;
        String[] example31 = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int example32 = 1802;
        String[] example41 = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int example42 = 2;
        String[] example51 = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int example52 = 3;
        String[] example61 = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int example62 = 10;
        String[] example71 = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int example72 = 534;
        String[] example81 = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int example82 = 5033;
        String[] example91 = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int example92 = 10010;
        String[] example101 = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int example102 = 3667;
        String[] example111 = {"Daisuke Aramaki", "Motoko Kusanagi", "Batou", "Togusa", "Ishikawa", "Saito", "Pazu", "Borma", "Azuma", "Yano", "Proto"};
        int example112 = 527;
        String[] example121 = {"Daisuke Aramaki", "Motoko Kusanagi", "Batou", "Togusa", "Ishikawa", "Saito", "Pazu", "Borma", "Azuma", "Yano", "Proto"};
        int example122 = 124;
        String[] example131 = {"Daisuke Aramaki", "Motoko Kusanagi", "Batou", "Togusa", "Ishikawa", "Saito", "Pazu", "Borma", "Azuma", "Yano", "Proto"};
        int example132 = 1510222;

        System.out.println(whoIsNext(example01, example02)); // "Azuma"
        System.out.println(whoIsNext(example11, example12)); // "Sheldon"
        System.out.println(whoIsNext(example21, example22)); // "Sheldon"
        System.out.println(whoIsNext(example31, example32)); // "Penny"
        System.out.println(whoIsNext(example41, example42)); // "Leonard"
        System.out.println(whoIsNext(example51, example52)); // "Penny"
        System.out.println(whoIsNext(example61, example62)); // "Penny"
        System.out.println(whoIsNext(example71, example72)); // "Rajesh"
        System.out.println(whoIsNext(example81, example82)); // "Howard"
        System.out.println(whoIsNext(example91, example92)); // "Howard"
        System.out.println(whoIsNext(example101, example102)); // "Penny"
        System.out.println(whoIsNext(example111, example112)); // "Saito"
        System.out.println(whoIsNext(example121, example122)); // "Saito"
        System.out.println(whoIsNext(example131, example132)); // "Daisuke Aramaki"
    }
}
