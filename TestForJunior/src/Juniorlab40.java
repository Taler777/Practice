/*
Did you mean ...?

Все мы видели, как поисковик понимает неправильные слова и предлагает нам правильный вариант "Возможно вы имели ввиду...".
В этой задаче вам нужно реализовать нечто подобное.

Функция принимает два параметра: массив известных слов и слово, по которому будет вестись поиск.
Ваша задача - выяснить, какое слово из списка наиболее похожее на переданное.
Сходство описывается минимальным количество букв, которое можно добавить, удалить или заменить,
чтобы из переданного слова получить какое-либо слово из списка. Чем меньше количество изменений,
тем выше сходство между этими словами.

Вход	Выход
function Dictionary(['cherry', 'pineapple', 'melon', 'strawberry', 'raspberry'], 'strawbery');	    "strawberry"
function Dictionary(['cherry', 'pineapple', 'melon', 'strawberry', 'raspberry'], 'berry');  	"cherry"
function Dictionary(['stars', 'mars', 'wars', 'codec', 'codewars'], 'coddwars');	            "codewars"

 */

public class Juniorlab40 {
    public static String dictionary(String[] list, String word){
            String str1 = "Geekminds";

            // преобразую строки в символьные массивы
            char a[] = convertStringToChar(str1);
            char b[] = convertStringToChar(word);
            int row = a.length, col = b.length;
            //создаю матрицу
            int map[][] = new int[row + 1][col + 1];
            for (int i = 0; i < col; i++) {
                map[0][i] = 0; // заполняю первую строку нулями
            }
            for (int i = 0; i < row; i++) {
                map[i][0] = 0; // заполняю первы столбец нулями
            }
            map = compare(a, b, row, col, map);
            // печатаю матрицу
            for (int i = 0; i < row + 1; i++) {
                for (int j = 0; j < col + 1; j++) {
                    System.out.format("%3d", map[i][j]);
                }
                System.out.println();
            }
            System.out.println("Наибольшая общая длина подпоследовательности - " + map[row][col]);
            return "";
        }

        // сравнение двух строк
        public static int[][] compare(char[] a, char[] b, int row, int col, int[][] map) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (a[i] == b[j]) {
                        map[i + 1][j + 1] = 1 + map[i][j];
                    } else map[i + 1][j + 1] = Math.max(map[i][j + 1], map[i + 1][j]);
                }
            }
            return map;
        }

        // преобразую слово в массив символов
        public static char[] convertStringToChar(String str) {
            return str.toCharArray();
        }


    public static void main(String[] args) {
        String[] example01 = { "ruby",   "php",   "javascript",   "brainfuck",   "cpp",   "python",   "coffeescript",   "java",   "c" };
        String example02 = "javascript";
        String[] example11 = { "strawberry",  "raspberry", "banana",   "pineapple",   "coconut",   "melon",   "apple",   "peach",   "cherry" };
        String example12 = "strawbery";
        String[] example21 = { "strawberry",  "raspberry", "banana",   "pineapple",   "coconut",   "melon",   "apple",   "peach",   "cherry" };
        String example22 = "berry";
        String[] example31 = { "strawberry",  "raspberry", "banana",   "pineapple",   "coconut",   "melon",   "apple",   "peach",   "cherry" };
        String example32 = "aple";
        String[] example41 = { "mars", "codewars", "code", "stars", "wars", "codec" };
        String example42 = "coddwars";
        String[] example51 = { "ruby",   "php",   "javascript",   "brainfuck",   "cpp",   "python",   "coffeescript",   "java",   "c" };
        String example52 = "heaven";
        String[] example61 = {"hwzsemiqxjwfk", "pxyousorusjxxbt", "cfvruditwcxr", "kqijoorfkejdcxr", "hkldhadcxrjbmkmcdi", "ppctybxgtleipb", "znystgvifufptxr", "afirbipbmkamjzw", "hirldidcuzbyb", "jcocndjkyb", "xffrkbdyjveb", "emvquxrvvlvwvsi", "eglanhfredaykxr", "ntwmwwmicnjvhtt", "ajacizfrgxfumzpvi", "sefsknopiffajor", "cpnqknjyviusknmte", "nnsoamjkrzgldi", "hrwuhmtxxvmygb", "iqkyztorburjgiudi", "xrgdgqfrldwk", "fgtrjakzlnaebxr", "npyrgrpbdfqhhncdi", "qojfrlhufr", "mhmkakybpczjbb", "psaysnhfrrqgxwik", "vkholxrvjwisrk", "tdvibqccxr", "osbednerciaai", "ggcvrtxrtnafw", "cwhyyzaorpvtnlfr", "qifwqgdsijibor", "loogviwcojxgvi", "xuwahveztwoor", "pdyjrkaylryr", "karpscdigdvucfr", "tklquxrnhfiggb", "dihhiczkdwiofpr", "xikoctmrhpvi", "ucxmdeudiycokfnb", "fxpvfhfrujjaifr", "riyhpvimgaliuxr", "ljxzjjorwgb", "lnjhrzfrosinb", "iroezmixmberfr", "dyhxgviphoptak", "jhjyasikwyufr", "zqdrhpviqslik", "clxmqmiycvidiyr", "fxjskybblljqr"};
        String example62 = "rkacypviuburk";


        System.out.println(dictionary(example01, example02)); // "javascript"
        System.out.println(dictionary(example11, example12)); // "strawberry"
        System.out.println(dictionary(example21, example22)); // "cherry"
        System.out.println(dictionary(example31, example32)); // "apple"
        System.out.println(dictionary(example41, example42)); // "codewars"
        System.out.println(dictionary(example51, example52)); // "java"
        System.out.println(dictionary(example61, example62)); // "zqdrhpviqslik"
    }
}
