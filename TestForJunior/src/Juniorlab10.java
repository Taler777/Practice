/*
Human Readable Time
Напишите функцию, которая принимает количество секунд и возвращает время в удобном для человека формате (HH:MM:SS)

HH - часы, которые содержат две цифры, от 00 до 99
MM - минуты, которые содержат две цифры, от 00 до 59
SS - секунды, которые содержат две цифры, от 00 до 59
Максимальное время 359999 секунд (99:59:59)
 */

public class Juniorlab10 {

    public static String humanReadable(int seconds) {
        String hour = new String();
        String minute = new String();
        String second = new String();
        String time = new String();

        hour += seconds / 3600;
        if (hour.length() == 1) {
            hour = "0" + hour;
        }
        minute += (seconds % 3600) / 60;
        if (minute.length() == 1) {
            minute = "0" + minute;
        } else if ((seconds % 3600) / 60 > 59) {
            minute = "59";
        }
        second += (seconds % 3600) % 60;
        if (second.length() == 1) {
            second = "0" + second;
        } else if ((seconds % 3600) % 60 > 59) {
            second = "59";
        }
        time = hour + ":" + minute + ":" + second;
        return time;
    }

    public static void main(String[] args) {
        int example01 = 359999;
        int example11 = 0;
        int example21 = 59;
        int example31 = 60;
        int example41 = 90;
        int example51 = 3599;
        int example61 = 3600;
        int example71 = 45296;
        int example81 = 86399;
        int example91 = 86400;

        System.out.println(humanReadable(example01));
        System.out.println(humanReadable(example11));
        System.out.println(humanReadable(example21));
        System.out.println(humanReadable(example31));
        System.out.println(humanReadable(example41));
        System.out.println(humanReadable(example51));
        System.out.println(humanReadable(example61));
        System.out.println(humanReadable(example71));
        System.out.println(humanReadable(example81));
        System.out.println(humanReadable(example91));

    }
}
