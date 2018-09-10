/*
Now that's a crib!

Входной аргумент n указывает количество этажей в пентхаусе. Постройте дом следующим образом:

        ___
       /___\
      /_____\
      |  _  |  // 1 floor
      |_|_|_|

       _____
      /_____\
     /_______\
    /_________\
   /___________\
   |           |
   |    ___    |  // 2 floors
   |   |   |   |
   |___|___|___|

      _______
     /_______\
    /_________\
   /___________\
  /_____________\
 /_______________\
/_________________\
|                 |      // 3 floors
|                 |
|      _____      |
|     |     |     |
|     |     |     |
|_____|_____|_____|
 */

public class Juniorlab23 {
    public static String myCrib(int n) {
        String[] example = new String[5];
        example[0] = "  ___";
        example[1] = " /___\\";
        example[2] = "/_____\\";
        example[3] = "|  _  |";
        example[4] = "|_|_|_|";
        for (int i = 0; i < example.length; i++) {
            System.out.println(example[i]);
        }
return null;
    }

    public static void main(String[] args) {
        int example01 = 14;
        int example11 = 1;
        int example21 = 2;
        int example31 = 3;
        int example41 = 26;

        System.out.println(myCrib(example01));
        System.out.println(myCrib(example11));
        System.out.println(myCrib(example21));
        System.out.println(myCrib(example31));
        System.out.println(myCrib(example41));
    }

}
