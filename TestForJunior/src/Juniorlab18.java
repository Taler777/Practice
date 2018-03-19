/*
Directions Reduction

Нужно прийти из одной точки к другой. Есть четыре направления: север, юг, запад и восток.
Как мы знаем, север и юг являются противоположными направлениями, как и запад и восток друг относительно друга.
Очевидно, что идти, например, сначала на север, а потом сразу на юг, пустая трата времени и сил.
Поэтому, нужно оставить только те направления, которые имеют смысл.

Если дан маршрут ["EAST", "WEST"], то "EAST" и "WEST" гасят друг друга.
Нет смысла вообще двигаться с места, поэтому результатом будет пустой массив []

Не все пути можно упростить. Например, путь ["NORTH", "WEST", "SOUTH", "EAST"] не упрощается.
"NORTH" и "WEST", "WEST" и "SOUTH", "SOUTH" и "EAST" не прямо противоположны друг другу.
Значит результатом будет: ["NORTH", "WEST", "SOUTH", "EAST"].

 */
/*
CRAZY CODE )))) SORRY
*/

import java.util.Arrays;

public class Juniorlab18 {

    public static String[] dirReduc(String[] arr) {
        boolean repeat;
        String clearDirection;
        do {
            clearDirection = new String();
            repeat = false;
            for (int i = 0; i < arr.length - 1; i++) {
                // если соседние шаги равны
                if (arr[i].equals(arr[i + 1])) {
                    // оставляем arr[i]
                    clearDirection += arr[i] + " ";
                    if (i == (arr.length - 2)) {
                        clearDirection += arr[i + 1];
                    }
                    //если соседние шаги не взаимоисключающие
                } else if (
                        (
                                (arr[i].equals("NORTH") || arr[i].equals("SOUTH")) &&
                                        (arr[i + 1].equals("WEST") || arr[i + 1].equals("EAST"))
                        )
                                ||
                                (
                                        (arr[i].equals("WEST") || arr[i].equals("EAST")) &&
                                                (arr[i + 1].equals("NORTH") || arr[i + 1].equals("SOUTH"))
                                )
                        ) {
                    // оставляем arr[i]
                    clearDirection += arr[i] + " ";
                    if (i == (arr.length - 2)) {
                        clearDirection += arr[i + 1];
                    }
                    //если соседние шаги взаимоисключающие
                } else if (
                        (arr[i].equals("NORTH") && arr[i + 1].equals("SOUTH")) ||
                                (arr[i].equals("SOUTH") && arr[i + 1].equals("NORTH")) ||
                                (arr[i].equals("WEST") && arr[i + 1].equals("EAST")) ||
                                (arr[i].equals("EAST") && arr[i + 1].equals("WEST"))
                        ) {
                    // убираем arr[i] и arr[i+1]
                    if (i + 2 < arr.length - 1) {
                        i += 1;
                    } else if (i == arr.length - 3) {
                        clearDirection += arr[arr.length - 1];
                        //arr = clearDirection.split(" ");
                        break;
                    } else if (i > arr.length - 3 && clearDirection.equals("")) {
                        arr = new String[]{};
                        break;
                    }
                }
            }
            clearDirection.trim();
            if (clearDirection.equals("")) {
                if (arr.length == 1) {
                    break;
                } else if (arr.length==0){
                    break;
                }
                arr = clearDirection.split(" ");
                continue;
            }
            if (arr.length > clearDirection.split(" ").length) {
                arr = clearDirection.split(" ");
                repeat = true;
            } else if (arr.length == clearDirection.split(" ").length) {
                arr = clearDirection.split(" ");
                repeat = false;
            }
        } while (repeat);
        return arr;
    }

    public static void main(String[] args) {
        String[] example01 = {"NORTH", "WEST", "SOUTH", "EAST"};
        String[] example11 = {"EAST", "WEST", "NORTH", "SOUTH", "NORTH", "NORTH", "NORTH", "WEST", "EAST", "SOUTH", "NORTH"};
        String[] example21 = {"WEST", "EAST", "SOUTH", "NORTH", "NORTH", "EAST", "EAST", "WEST", "NORTH", "SOUTH"};
        String[] example31 = {"WEST", "EAST", "NORTH", "SOUTH", "EAST", "SOUTH", "WEST", "EAST", "SOUTH", "NORTH"};
        String[] example41 = {"NORTH", "SOUTH", "EAST", "WEST", "NORTH", "SOUTH", "SOUTH", "WEST", "WEST", "EAST", "NORTH", "SOUTH", "EAST", "WEST"};
        String[] example51 = {"WEST", "EAST", "SOUTH", "NORTH", "WEST", "NORTH", "EAST", "WEST", "NORTH", "SOUTH"};
        String[] example61 = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};
        String[] example71 = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"};

        System.out.println(Arrays.toString(dirReduc(example01))); // { "NORTH", "WEST", "SOUTH", "EAST" }
        System.out.println(Arrays.toString(dirReduc(example11))); // {"NORTH", "NORTH", "NORTH"}
        System.out.println(Arrays.toString(dirReduc(example21))); // {"NORTH", "EAST"}
        System.out.println(Arrays.toString(dirReduc(example31))); // {"EAST", "SOUTH"}
        System.out.println(Arrays.toString(dirReduc(example41))); // {"SOUTH", "WEST"}
        System.out.println(Arrays.toString(dirReduc(example51))); // {"WEST", "NORTH"}
        System.out.println(Arrays.toString(dirReduc(example61))); // {"WEST"}
        System.out.println(Arrays.toString(dirReduc(example71))); // {}
       // System.out.println(dirReduc(example71).length); // {}
    }
}
