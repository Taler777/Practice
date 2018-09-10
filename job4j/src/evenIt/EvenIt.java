package evenIt;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] values;
    private int currentPosition;
    private int lastSeenIndex;

    public EvenIt(final int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        int index = lastSeenIndex;
        index++;
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        int index = currentPosition;
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                lastSeenIndex = currentPosition++;
                return values[i];
            }
            lastSeenIndex = currentPosition++;
        }
        if (currentPosition >= values.length) {

            throw new NoSuchElementException();

        }
        return null;
    }
}