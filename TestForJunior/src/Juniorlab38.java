/*
Rectangle Rotation

На плоскости изображен прямоугольник со сторонами a и b.
Центр этого прямоугольника совпадает с началом координат (0, 0), но его стороны не параллельны осям.
Вместо этого они образуют с осями углы 45 градусов.

Сколько точек с целыми координатами расположено внутри прямоугольника( включая его стороны).

Например:
Для a = 6 и b = 4 функция должна вернуть 23.

На рисунке ниже показан пример, а 23 точки отмечены зеленым.

 */


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Juniorlab38 {
    public static int rectangleRotation(int a, int b) {

        int result = 0;
        //выяснить куда повернули - новые координаты
        double x = a / 2;
        double y = b / 2;
        double x1 = x, y1 = y;
        double x2 = x, y2 = -y;
        double x3 = -x, y3 = -y;
        double x4 = -x, y4 = y;
        System.out.println(x4 + "   " + y4 + "   " + x1 + "   " + y1);
        System.out.println(x3 + "   " + y3 + "   " + x2 + "   " + y2);
        double conerX1 = (x1 * Math.cos(45) - y1 * Math.sin(45));
        conerX1 = roundDouble(conerX1);
        double conerY1 = (x1 * Math.sin(45) + y1 * Math.cos(45));
        conerY1 = roundDouble(conerY1);
        double conerX2 = (x2 * Math.cos(45) - y2 * Math.sin(45));
        conerX2 = roundDouble(conerX2);
        double conerY2 = (x2 * Math.sin(45) + y2 * Math.cos(45));
        conerY2 = roundDouble(conerY2);
        double conerX3 = (x3 * Math.cos(45) - y3 * Math.sin(45));
        conerX3 = roundDouble(conerX3);
        double conerY3 = (x3 * Math.sin(45) + y3 * Math.cos(45));
        conerY3 = roundDouble(conerY3);
        double conerX4 = (x4 * Math.cos(45) - y4 * Math.sin(45));
        conerX4 = roundDouble(conerX4);
        double conerY4 = (x4 * Math.sin(45) + y4 * Math.cos(45));
        conerY4 = roundDouble(conerY4);

        System.out.println(conerX4 + "   " + conerY4 + "   " + conerX1 + "   " + conerY1);
        System.out.println(conerX3 + "   " + conerY3 + "   " + conerX2 + "   " + conerY2);

        //   (x A -x B) (y P -y B) - (y A -y B) (x P -x B)>=0

        int counterBorder = 0;
        int counterIn = 0;
        int counterOut = 0;

        for (int i = (int) conerY3; i < conerY1; i++) {
            for (int j = (int) conerX4; j < conerX2; j++) {
                double side14 = isIn(j, i, conerX1, conerY1, conerX4, conerY4);
                double side43 = isIn(j, i, conerX4, conerY4, conerX3, conerY3);
                double side32 = isIn(j, i, conerX3, conerY3, conerX2, conerY2);
                double side21 = isIn(j, i, conerX2, conerY2, conerX1, conerY1);
                if (side14 > 0 && side43 > 0 && side32 > 0 && side21 > 0) {
                    counterIn++;
                } else if (side14 == 0 && side43 == 0 && side32 == 0 && side21 == 0) {
                    counterBorder++;
                } else {
                    counterOut++;
                }
            }
        }
        System.out.println("Inside " + counterIn + "    Border " + counterBorder + "    Out " + counterOut);

        return result;
    }

    public static double roundDouble(double number) {
        number *= 100000;
        int temp = (int) Math.round(number);
        return (double) temp / 100000;
//        double result = new BigDecimal(number).setScale(2, RoundingMode.UP).doubleValue();
//        return  result;
    }

    public static double isIn(double xPoint, double yPoint, double xA, double yA, double xB, double yB) {
        return ((xB - xA)) * (yPoint - yA) - (yB - yA) * (xPoint - xA);
    }

    public static void main(String[] args) {
        int example01 = 1924;
        int example02 = 6584;
        int example11 = 6;
        int example12 = 4;
        int example21 = 30;
        int example22 = 2;
        int example31 = 8;
        int example32 = 6;
        int example41 = 16;
        int example42 = 20;
        int example51 = 5742;
        int example52 = 4444;
        int example61 = 2242;
        int example62 = 2908;
        int example71 = 5498;
        int example72 = 2768;
        int example81 = 8384;
        int example82 = 4192;
        int example91 = 2440;
        int example92 = 9460;
        int example101 = 4666;
        int example102 = 5454;
        int example111 = 8560;
        int example112 = 6946;

        System.out.println(rectangleRotation(example01, example02)); // 12667615
        System.out.println(rectangleRotation(example11, example12)); // 23
        System.out.println(rectangleRotation(example21, example22)); // 65
        System.out.println(rectangleRotation(example31, example32)); // 49
        System.out.println(rectangleRotation(example41, example42)); // 333
        System.out.println(rectangleRotation(example51, example52)); // 25520243
        System.out.println(rectangleRotation(example61, example62)); // 6521161
        System.out.println(rectangleRotation(example71, example72)); // 15219563
        System.out.println(rectangleRotation(example81, example82)); // 35150077
        System.out.println(rectangleRotation(example91, example92)); // 23085465
        System.out.println(rectangleRotation(example101, example102)); // 25449043
        System.out.println(rectangleRotation(example111, example112)); // 59453707
    }
}
