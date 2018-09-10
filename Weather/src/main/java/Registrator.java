import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registrator {


    private Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}");

    private Document getPage2() throws IOException {
        String url = "http://pogoda.spb.ru/";
        Document page = Jsoup.parse(new URL(url), 3000);  //получаем страницу из URL и указываем время ожидания ответа от сервера
        //метод parse парсит url  и создает документ page
        return page;
    }

    private String getDateFromString2(String stringDate) throws Exception {
        Matcher matcher = pattern.matcher(stringDate); //формируем искомую строку
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Can't extract date from string!");
    }

    // печатаю погоду по каждому из 4 времени дня
    private int printPartValues2(Elements values, int index) {
        int iterationCount = 4;
        if (index == 0) {
            Element valueLn = values.get(index); // берем первую строку и смотрим время суток
            // реализую без switch
            boolean isMorning = valueLn.text().contains("Утро");
            boolean isEvening = valueLn.text().contains("Вечер");
            boolean isDay = valueLn.text().contains("День");
            boolean isNight = valueLn.text().contains("Ночь");
            if (isMorning) {
                iterationCount = 4;
            } else if (isDay) {
                iterationCount = 3;
            } else if (isEvening) {
                iterationCount = 2;
            } else if (isNight) {
                iterationCount = 5;
            }
        }
        for (int i = 0; i < iterationCount; i++) {
            Element valueLine = values.get(index + i); // получаем линию значений - погода по времени суток
            //перебираем все td и выводим только текст
            for (Element td : valueLine.select("td")) {
                System.out.print(td.text() + "    ");
            }
            System.out.println();
        }
        return iterationCount;
    }

    public static void main(String[] args) throws Exception {
        Registrator registrator = new Registrator();

        Document page = registrator.getPage2();
        //css query language
        //запрашиваем у страницы page первый элемент table с классом wt, где находится таблица с погодой
        Element tableWheather = page.select("table[class=wt]").first();
        // выбираем все строки tr с классом wth - дни, на которые есть погода
        Elements names = tableWheather.select("tr[class=wth]");
        // выбираем все строки tr с выравнивание содержимого ячеек по вертикали (valign=top) - погода по времени суток
        Elements values = tableWheather.select("tr[valign=top]");
        int index = 0; // индекс для перебора values - значения погоды по времени суток
        //System.out.println(tableWheather);
        for (Element name : names) {
            //выбираем весь текст из ячейки
            String dateString = name.select("th[id=dt]").text();
            //вытаскиваем дату из текста с помощью регулярных выражений
            String date = registrator.getDateFromString2(dateString);
            System.out.println(date + "    Явления     Температура     Давление        Влажность");
            int iterationCount = registrator.printPartValues2(values, index);
            index += iterationCount;
        }
    }



}
