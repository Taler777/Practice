package wordIndex;
/**
 * Есть большой текстовый файл, в котором хранятся различные слова. Слова могут повторяться несколько раз.
 * <p>
 * Нужно сделать класс WordIndex (можно создавать и другие сопутствующие классы, если это необходимо),
 * который по сути будет являться индексом. Он должен позволять по заданному слову находить все вхождения (позиции) его в файле.
 * <p>
 * Например.
 * <p>
 * Для входной строки "Hello, world. Hello." при поиске слова "Hello" алгоритм должен вернуть множество {0, 14}.
 * <p>
 * В этом алгоритме мы будет оценивать скорость работы алгоритма.
 * <p>
 * Подумайте, какую структура данных лучше всего подходит для решения такой задачи.
 */


import java.util.HashSet;
import java.util.Set;

public final class WordIndex {
    private final String text;

    public WordIndex(final String text) {
        this.text = text;
    }

    public final Set<Integer> indexOf(final String word) {
        HashSet <Integer> treeSet = new HashSet();
        int wordPosition;
        for (int position = 0; position < text.length() - word.length(); position++) {
            wordPosition = text.indexOf(word, position);
            if (wordPosition == -1) {
                break;
            }
            treeSet.add(wordPosition);
            position = wordPosition;
        }
        return treeSet;
    }
}